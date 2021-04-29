package com.ask.qa_service.po;

import lombok.Data;

import java.util.Date;

@Data
public class AskAnswersCommentPo {
    private String id;

    private String answerNo;

    private String commentNo;

    private String orderNo;

    private String commentContent;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;
}