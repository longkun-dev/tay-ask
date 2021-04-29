package com.ask.qa_service.dao;

import com.ask.qa_service.po.AskUserPo;
import com.ask.qa_service.po.AskUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AskUserDao {
    long countByExample(AskUserExample example);

    int deleteByExample(AskUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(AskUserPo record);

    int insertSelective(AskUserPo record);

    List<AskUserPo> selectByExample(AskUserExample example);

    AskUserPo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AskUserPo record, @Param("example") AskUserExample example);

    int updateByExample(@Param("record") AskUserPo record, @Param("example") AskUserExample example);

    int updateByPrimaryKeySelective(AskUserPo record);

    int updateByPrimaryKey(AskUserPo record);
}