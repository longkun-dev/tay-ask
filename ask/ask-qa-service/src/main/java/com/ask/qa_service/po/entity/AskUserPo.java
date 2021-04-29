package com.ask.qa_service.po;

import lombok.Data;

import java.util.Date;

@Data
public class AskUserPo {
    private String id;

    private String userId;

    private String username;

    private String password;

    private String role;

    private Date lastLoginTime;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;
}