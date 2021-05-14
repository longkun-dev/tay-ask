package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.CommonCodePo;

/**
 * com.ask.qa_service.entity.po.CommonCode
 */
public interface CommonCodeDao {

    int insert(CommonCodePo commonCodePo);

    CommonCodePo selectByCodeName(String codeName);

    String selectLatestQuestionId();
}
