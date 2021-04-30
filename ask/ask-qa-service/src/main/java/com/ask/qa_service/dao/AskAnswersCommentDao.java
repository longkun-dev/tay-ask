package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.AskAnswersCommentPo;

public interface AskAnswersCommentDao {

    int deleteByPrimaryKey(String id);

    int insert(AskAnswersCommentPo record);

    int insertSelective(AskAnswersCommentPo record);

    AskAnswersCommentPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AskAnswersCommentPo record);

    int updateByPrimaryKey(AskAnswersCommentPo record);
}