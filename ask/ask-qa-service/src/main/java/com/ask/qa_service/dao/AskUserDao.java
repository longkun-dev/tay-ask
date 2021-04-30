package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.AskUserPo;

public interface AskUserDao {

    AskUserPo queryByUserId(String userId);

    int deleteByPrimaryKey(String id);

    int insert(AskUserPo record);

    int insertSelective(AskUserPo record);

    AskUserPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AskUserPo record);

    int updateByPrimaryKey(AskUserPo record);
}