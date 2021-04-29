package com.ask.qa_service.po;

import lombok.Data;

import java.util.Date;

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