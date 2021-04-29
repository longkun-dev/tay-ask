package com.ask.qa_service.dao;

import com.ask.qa_service.po.AskAnswersCommentPo;
import com.ask.qa_service.po.AskAnswersCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AskAnswersCommentDao {
    long countByExample(AskAnswersCommentExample example);

    int deleteByExample(AskAnswersCommentExample example);

    int deleteByPrimaryKey(String id);

    int insert(AskAnswersCommentPo record);

    int insertSelective(AskAnswersCommentPo record);

    List<AskAnswersCommentPo> selectByExample(AskAnswersCommentExample example);

    AskAnswersCommentPo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AskAnswersCommentPo record, @Param("example") AskAnswersCommentExample example);

    int updateByExample(@Param("record") AskAnswersCommentPo record, @Param("example") AskAnswersCommentExample example);

    int updateByPrimaryKeySelective(AskAnswersCommentPo record);

    int updateByPrimaryKey(AskAnswersCommentPo record);
}