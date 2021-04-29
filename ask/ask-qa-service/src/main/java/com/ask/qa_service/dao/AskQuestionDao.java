package com.ask.qa_service.dao;

import com.ask.qa_service.po.AskQuestionPo;
import com.ask.qa_service.po.AskQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AskQuestionDao {
    long countByExample(AskQuestionExample example);

    int deleteByExample(AskQuestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(AskQuestionPo record);

    int insertSelective(AskQuestionPo record);

    List<AskQuestionPo> selectByExample(AskQuestionExample example);

    AskQuestionPo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AskQuestionPo record, @Param("example") AskQuestionExample example);

    int updateByExample(@Param("record") AskQuestionPo record, @Param("example") AskQuestionExample example);

    int updateByPrimaryKeySelective(AskQuestionPo record);

    int updateByPrimaryKey(AskQuestionPo record);
}