package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.AskUserExtPo;

public interface AskUserExtDao {

    int deleteByPrimaryKey(String id);

    int insert(AskUserExtPo record);

    int insertSelective(AskUserExtPo record);

    AskUserExtPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AskUserExtPo record);

    int updateByPrimaryKey(AskUserExtPo record);
}