package com.ask.qa_service.entity.po;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "问题回答实体类")
@Data
public class AskAnswersContentPo {
    private String id;

    private String questionNo;

    private String answerNo;

    private String orderNo;

    private String answeredBy;

    private Integer votes;

    private Date publishTime;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private String answersContent;
}