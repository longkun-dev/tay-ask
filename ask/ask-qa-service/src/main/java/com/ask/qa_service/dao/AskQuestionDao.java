package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.AskQuestionPo;

import java.util.List;

public interface AskQuestionDao {

    int deleteByPrimaryKey(String id);

    int deleteByQuestionNo(String questionNo);

    int insert(AskQuestionPo record);

    int insertSelective(AskQuestionPo record);

    AskQuestionPo selectByPrimaryKey(String id);

    AskQuestionPo selectByQuestionNo(String questionNo);

    List<AskQuestionPo> selectByCount(Integer count);

    List<AskQuestionPo> selectQuestionByCreateTime(Integer count);

    int selectCount();

    int updateByPrimaryKeySelective(AskQuestionPo record);

    int updateByPrimaryKey(AskQuestionPo record);
}