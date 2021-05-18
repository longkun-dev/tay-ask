package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.AskQuestionPo;

public interface AskQuestionDao {

    int deleteByPrimaryKey(String id);

    int deleteByQuestionNo(String questionNo);

    int insert(AskQuestionPo record);

    int insertSelective(AskQuestionPo record);

    AskQuestionPo selectByPrimaryKey(String id);

    AskQuestionPo selectByQuestionNo(String questionNo);

    int updateByPrimaryKeySelective(AskQuestionPo record);

    int updateByPrimaryKey(AskQuestionPo record);
}