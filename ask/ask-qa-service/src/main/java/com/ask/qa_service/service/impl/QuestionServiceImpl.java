package com.ask.qa_service.service.impl;

import com.ask.qa_service.common.RequestUtils;
import com.ask.qa_service.dao.AskQuestionDao;
import com.ask.qa_service.common.UUIDUtils;
import com.ask.qa_service.constant.Constant;
import com.ask.qa_service.dao.AskQuestionContentDao;
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
import java.util.Objects;

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

        String currentUserId = RequestUtils.getCurrentUserId();

        questionPo.setId(UUIDUtils.randomUUID36());
        questionPo.setQuestionNo(generateQuestionNo());
        questionPo.setPublishTime(new Date());
        questionPo.setVotes(0);
        questionPo.setAnswers(0);
        questionPo.setViews(0);
        questionPo.setAskedBy(currentUserId);
        questionPo.setCreatedBy(currentUserId);
        questionPo.setUpdatedBy(currentUserId);

        questionDao.insert(questionPo);

        AskQuestionContentPo questionContentPo = new AskQuestionContentPo();
        questionContentPo.setId(UUIDUtils.randomUUID36());
        questionContentPo.setQuestionNo(questionPo.getQuestionNo());
        questionContentPo.setQuestionContent(questionPo.getQuestionContent());
        questionContentPo.setCreatedBy(currentUserId);
        questionContentPo.setUpdatedBy(currentUserId);
        questionContentDao.insert(questionContentPo);

        return "问题已成功发布";
    }

    /**
     * 生成问题编号
     *
     * @return 一个可用的问题编号
     */
    @Override
    public String generateQuestionNo() {
        String newQuestionNo;
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.DATE_FORMAT_yyyyMMdd);
        String prefix = Constant.QUESTION_ID_PREFIX + dateFormat.format(new Date());
        String currentUserId = RequestUtils.getCurrentUserId();
        CommonCodePo codePo = codeDao.selectByCodeName(Constant.LATEST_QUESTION_ID);
        if (codePo != null) {
            String codePrefix = codePo.getCodeValue().substring(0, 9);
            if (Objects.equals(prefix, codePrefix)) {
                String baseNum = codePo.getCodeValue().substring(9);
                String newNum = StringUtils.leftPad(String.valueOf(Integer.parseInt(baseNum) + 1), 6,
                        '0');
                newQuestionNo = codePo.getCodeValue().substring(0, 9) + newNum;
            } else {
                newQuestionNo = prefix + Constant.QUESTION_ID_START;
            }
            codePo.setCodeValue(newQuestionNo);
            codePo.setRemark("最近生成的问题编号");
            codePo.setUpdatedBy(currentUserId);
            codeDao.updateCodeValueByCodeName(codePo);
        } else {
            newQuestionNo = Constant.QUESTION_ID_PREFIX + dateFormat.format(new Date())
                    + Constant.QUESTION_ID_START;
            codePo = new CommonCodePo();
            codePo.setId(UUIDUtils.randomUUID36());
            codePo.setCodeName(Constant.LATEST_QUESTION_ID);
            codePo.setCodeValue(newQuestionNo);
            codePo.setRemark("最近生成的问题编号");
            codePo.setCreatedBy(currentUserId);
            codePo.setUpdatedBy(currentUserId);
            codeDao.insert(codePo);
        }

        return newQuestionNo;
    }

    @Override
    public AskQuestionPo getQuestion(String questionNo) {
        if (StringUtils.isEmpty(questionNo)) {
            return null;
        }
        return questionDao.selectByQuestionNo(questionNo);
    }

    @Override
    public int deleteQuestion(String questionNo) {
        if (StringUtils.isEmpty(questionNo)) {
            return 0;
        }
        return questionDao.deleteByQuestionNo(questionNo);
    }
}
