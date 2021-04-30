package com.ask.qa_service.service;

import com.ask.qa_service.entity.po.AskQuestionPo;

/**
 * 业务接口类
 *
 * @author zhulongkun20@163.com
 * @since 2021/4/30 11:22 PM
 */
public interface QuestionService {

    /**
     * 新增问题
     *
     * @param questionPo 问题实体类
     * @return 处理结果
     */
    String newQuestion(AskQuestionPo questionPo);
}
