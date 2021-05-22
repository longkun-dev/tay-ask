package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.CommonCodePo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * com.ask.qa_service.entity.po.CommonCode
 */
public interface CommonCodeDao {

    int insert(CommonCodePo commonCodePo);

    int insertBatch(@Param("list") List<CommonCodePo> commonCodePoList);

    int updateCodeValueByCodeName(CommonCodePo commonCodePo);

    List<CommonCodePo> selectByCodeName(String codeName);

    String selectLatestQuestionId();
}
