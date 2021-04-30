package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.AskAnswersContentPo;

public interface AskAnswersContentDao {


    int deleteByPrimaryKey(String id);

    int insert(AskAnswersContentPo record);

    int insertSelective(AskAnswersContentPo record);

    AskAnswersContentPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AskAnswersContentPo record);

    int updateByPrimaryKeyWithBLOBs(AskAnswersContentPo record);

    int updateByPrimaryKey(AskAnswersContentPo record);
}