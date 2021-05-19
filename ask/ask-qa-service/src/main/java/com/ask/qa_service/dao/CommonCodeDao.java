package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.CommonCodePo;
import org.apache.ibatis.annotations.Param;

/**
 * com.ask.qa_service.entity.po.CommonCode
 */
public interface CommonCodeDao {

    int insert(CommonCodePo commonCodePo);

    int updateCodeValueByCodeName(CommonCodePo commonCodePo);

    CommonCodePo selectByCodeName(String codeName);

    String selectLatestQuestionId();
}
