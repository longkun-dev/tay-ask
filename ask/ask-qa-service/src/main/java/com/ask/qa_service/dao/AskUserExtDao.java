package com.ask.qa_service.dao;

import com.ask.qa_service.po.AskUserExtPo;
import com.ask.qa_service.po.AskUserExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AskUserExtDao {
    long countByExample(AskUserExtExample example);

    int deleteByExample(AskUserExtExample example);

    int deleteByPrimaryKey(String id);

    int insert(AskUserExtPo record);

    int insertSelective(AskUserExtPo record);

    List<AskUserExtPo> selectByExample(AskUserExtExample example);

    AskUserExtPo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AskUserExtPo record, @Param("example") AskUserExtExample example);

    int updateByExample(@Param("record") AskUserExtPo record, @Param("example") AskUserExtExample example);

    int updateByPrimaryKeySelective(AskUserExtPo record);

    int updateByPrimaryKey(AskUserExtPo record);
}