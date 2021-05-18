package com.ask.qa_service.entity.po;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel("用户实体类")
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

    private String updatedTime;
}