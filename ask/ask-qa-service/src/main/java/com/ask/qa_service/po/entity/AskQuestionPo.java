package com.ask.qa_service.po;

import lombok.Data;

import java.util.Date;

@Data
public class AskQuestionPo {
    private String id;

    private String questionNo;

    private Date publishTime;

    private String questionContent;

    private Integer votes;

    private Integer answers;

    private Integer views;

    private String tags;

    private String askedBy;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;
}