package com.ask.qa_service.service.impl;

import com.ask.qa_service.dao.AskQuestionDao;
import com.ask.qa_service.entity.po.AskQuestionPo;
import com.ask.qa_service.service.QuestionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/30 11:23 PM
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private AskQuestionDao questionDao;

    @Override
    public String newQuestion(AskQuestionPo questionPo) {
        if (questionPo == null || StringUtils.isEmpty(questionPo.getQuestionTitle())
                || StringUtils.isEmpty(questionPo.getQuestionContent())) {
            return "问题发布失败，问题标题和问题内容不能为空";
        }

        return "问题发布成功";
    }

    @Override
    public AskQuestionPo getQuestion(String questionNo) {
        if (StringUtils.isEmpty(questionNo)) {
            return null;
        }
        return questionDao.selectByPrimaryKey(questionNo);
    }
}
