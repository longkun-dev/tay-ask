package com.ask.qa_service.po;

import lombok.Data;

import java.util.Date;

@Data
public class AskQuestionContentPo {
    private String id;

    private String questionNo;

    private String questionContent;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;
}