package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.AskUserPo;
import com.ask.qa_service.entity.po.AskUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AskUserDao {

    AskUserPo queryByUserId(String userId);

    int deleteByPrimaryKey(String id);

    int insert(AskUserPo record);

    int insertSelective(AskUserPo record);


    AskUserPo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AskUserPo record, @Param("example") AskUserExample example);

    int updateByPrimaryKeySelective(AskUserPo record);

    int updateByPrimaryKey(AskUserPo record);
}