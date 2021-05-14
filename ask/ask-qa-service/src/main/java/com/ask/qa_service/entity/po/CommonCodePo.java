package com.ask.qa_service.entity.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 基础变量表
 * 表名: common_code
 */
@Data
public class CommonCodePo implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String codeName;

    /**
     * 值
     */
    private String codeValue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新者
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

    private static final long serialVersionUID = 1L;
}