package com.ask.qa_service.entity.po;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "用户附加信息实体类")
@Data
public class AskUserExtPo {
    private String id;

    private String userId;

    private Integer goldBadges;

    private Integer silverBadges;

    private Integer bronzeBadges;

    private Integer reputationScore;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;
}