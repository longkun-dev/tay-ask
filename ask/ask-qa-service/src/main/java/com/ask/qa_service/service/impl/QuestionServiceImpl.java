package com.ask.qa_service.service.impl;

import com.ask.qa_service.common.UUIDUtils;
import com.ask.qa_service.constant.Constant;
import com.ask.qa_service.dao.AskQuestionDao;
import com.ask.qa_service.dao.CommonCodeDao;
import com.ask.qa_service.entity.po.AskQuestionPo;
import com.ask.qa_service.entity.po.CommonCodePo;
import com.ask.qa_service.service.QuestionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/30 11:23 PM
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private AskQuestionDao questionDao;

    @Autowired
    private CommonCodeDao codeDao;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @Override
    public String newQuestion(AskQuestionPo questionPo) {
        if (questionPo == null || StringUtils.isEmpty(questionPo.getQuestionTitle())
                || StringUtils.isEmpty(questionPo.getQuestionContent())) {
            return "问题发布失败，问题标题和问题内容不能为空";
        }

        questionPo.setId(UUIDUtils.randomUUID36());
        questionPo.setQuestionNo(generateQuestionId());
        questionPo.setCreatedBy("system");
        questionPo.setUpdatedBy("system");
        questionDao.insert(questionPo);

        return "问题已成功发布";
    }

    /**
     * 生成问题编号
     *
     * @return 一个可用的问题编号
     */
    private String generateQuestionId() {
        String newQuestionId;
        CommonCodePo codePo = codeDao.selectByCodeName(Constant.LATEST_QUESTION_ID);
        if (codePo != null && StringUtils.isNotEmpty(codePo.getCodeValue())) {
            String baseNum = codePo.getCodeValue().substring(6);
            String newNum = String.valueOf(Integer.parseInt(baseNum) + 1);
            newQuestionId = codePo.getCodeValue().substring(0, 9) + newNum;
        } else {
            newQuestionId = Constant.QUESTION_ID_PREFIX + dateFormat.format(new Date()) + Constant.QUESTION_ID_START;
            codePo = new CommonCodePo();
            codePo.setCreatedBy("system");
        }
        codePo.setCodeValue(newQuestionId);
        codePo.setUpdatedBy("system");
        codeDao.insert(codePo);
        return newQuestionId;
    }
}
