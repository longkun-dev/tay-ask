package com.ask.qa_service.service.impl;

import com.ask.qa_service.common.UUIDUtils;
import com.ask.qa_service.constant.Constant;
import com.ask.qa_service.dao.AskQuestionContentDao;
import com.ask.qa_service.dao.AskQuestionDao;
import com.ask.qa_service.dao.CommonCodeDao;
import com.ask.qa_service.entity.po.AskQuestionContentPo;
import com.ask.qa_service.entity.po.AskQuestionPo;
import com.ask.qa_service.entity.po.CommonCodePo;
import com.ask.qa_service.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/30 11:23 PM
 */
@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private AskQuestionDao questionDao;

    @Autowired
    private CommonCodeDao codeDao;

    @Autowired
    private AskQuestionContentDao questionContentDao;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @Transactional
    @Override
    public String newQuestion(AskQuestionPo questionPo) {
        if (questionPo == null || StringUtils.isEmpty(questionPo.getQuestionTitle())
                || StringUtils.isEmpty(questionPo.getQuestionContent())) {
            return "问题发布失败，问题标题和问题内容不能为空";
        }

        questionPo.setId(UUIDUtils.randomUUID36());
        questionPo.setQuestionNo(generateQuestionNo());
        questionPo.setPublishTime(new Date());
        questionPo.setVotes(0);
        questionPo.setAnswers(0);
        questionPo.setViews(0);
        questionPo.setAskedBy("currentUserId");
        questionPo.setCreatedBy("system");
        questionPo.setUpdatedBy("system");

        questionDao.insert(questionPo);

        AskQuestionContentPo questionContentPo = new AskQuestionContentPo();
        questionContentPo.setId(UUIDUtils.randomUUID36());
        questionContentPo.setQuestionNo(questionPo.getQuestionNo());
        questionContentPo.setQuestionContent(questionPo.getQuestionContent());
        questionContentPo.setCreatedBy("system");
        questionContentPo.setUpdatedBy("system");

        questionContentDao.insert(questionContentPo);

        return "问题已成功发布";
    }

    /**
     * 生成问题编号
     *
     * @return 一个可用的问题编号
     */
    private String generateQuestionNo() {
        String newQuestionNo;
        CommonCodePo codePo = codeDao.selectByCodeName(Constant.LATEST_QUESTION_ID);
        if (codePo != null && StringUtils.isNotEmpty(codePo.getCodeValue())) {
            String baseNum = codePo.getCodeValue().substring(9);
            String newNum = String.valueOf(Integer.parseInt(baseNum) + 1);
            newQuestionNo = codePo.getCodeValue().substring(0, 9) + newNum;
            codeDao.updateCodeValueByCodeName(Constant.LATEST_QUESTION_ID,
                    newQuestionNo);
        } else {
            newQuestionNo = Constant.QUESTION_ID_PREFIX + dateFormat.format(new Date()) + Constant.QUESTION_ID_START;
            codePo = new CommonCodePo();
            codePo.setId(UUIDUtils.randomUUID36());
            codePo.setCodeValue(newQuestionNo);
            codePo.setRemark("最近生成的问题编号");
            codePo.setCreatedBy("system");
            codePo.setUpdatedBy("system");
            codeDao.insert(codePo);
        }

        return newQuestionNo;
    }
}
