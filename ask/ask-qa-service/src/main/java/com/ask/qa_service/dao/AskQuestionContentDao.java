package com.ask.qa_service.dao;

import com.ask.qa_service.po.AskQuestionContentPo;
import com.ask.qa_service.po.AskQuestionContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AskQuestionContentDao {
    long countByExample(AskQuestionContentExample example);

    int deleteByExample(AskQuestionContentExample example);

    int deleteByPrimaryKey(String id);

    int insert(AskQuestionContentPo record);

    int insertSelective(AskQuestionContentPo record);

    List<AskQuestionContentPo> selectByExampleWithBLOBs(AskQuestionContentExample example);

    List<AskQuestionContentPo> selectByExample(AskQuestionContentExample example);

    AskQuestionContentPo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AskQuestionContentPo record, @Param("example") AskQuestionContentExample example);

    int updateByExampleWithBLOBs(@Param("record") AskQuestionContentPo record, @Param("example") AskQuestionContentExample example);

    int updateByExample(@Param("record") AskQuestionContentPo record, @Param("example") AskQuestionContentExample example);

    int updateByPrimaryKeySelective(AskQuestionContentPo record);

    int updateByPrimaryKeyWithBLOBs(AskQuestionContentPo record);

    int updateByPrimaryKey(AskQuestionContentPo record);
}