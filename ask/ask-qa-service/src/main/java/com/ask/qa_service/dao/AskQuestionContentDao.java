package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.AskQuestionContentPo;

public interface AskQuestionContentDao {


    int deleteByPrimaryKey(String id);

    int insert(AskQuestionContentPo record);

    int insertSelective(AskQuestionContentPo record);

    AskQuestionContentPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AskQuestionContentPo record);

    int updateByPrimaryKeyWithBLOBs(AskQuestionContentPo record);

    int updateByPrimaryKey(AskQuestionContentPo record);
}