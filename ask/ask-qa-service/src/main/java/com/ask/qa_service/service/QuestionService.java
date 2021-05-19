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

    /**
     * 生成一个可用的问题编号
     *
     * @return 一个可用的问题编号
     */
    String generateQuestionNo();

    /**
     * 根据问题编号查询问题
     *
     * @param questionNo 问题编号
     * @return 对应的问题
     */
    AskQuestionPo getQuestion(String questionNo);

    /**
     * 根据问题编号删除一个问题
     *
     * @param questionNo 问题编号
     * @return 删除成功或失败
     */
    int deleteQuestion(String questionNo);
}
