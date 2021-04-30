package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.AskAnswersContentPo;
import com.ask.qa_service.entity.po.AskAnswersContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AskAnswersContentDao {
    long countByExample(AskAnswersContentExample example);

    int deleteByExample(AskAnswersContentExample example);

    int deleteByPrimaryKey(String id);

    int insert(AskAnswersContentPo record);

    int insertSelective(AskAnswersContentPo record);

    List<AskAnswersContentPo> selectByExampleWithBLOBs(AskAnswersContentExample example);

    List<AskAnswersContentPo> selectByExample(AskAnswersContentExample example);

    AskAnswersContentPo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AskAnswersContentPo record, @Param("example") AskAnswersContentExample example);

    int updateByExampleWithBLOBs(@Param("record") AskAnswersContentPo record, @Param("example") AskAnswersContentExample example);

    int updateByExample(@Param("record") AskAnswersContentPo record, @Param("example") AskAnswersContentExample example);

    int updateByPrimaryKeySelective(AskAnswersContentPo record);

    int updateByPrimaryKeyWithBLOBs(AskAnswersContentPo record);

    int updateByPrimaryKey(AskAnswersContentPo record);
}