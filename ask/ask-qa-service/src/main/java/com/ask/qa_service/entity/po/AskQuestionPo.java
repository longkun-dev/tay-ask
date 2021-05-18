package com.ask.qa_service.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(description = "问题实体类")
@Data
public class AskQuestionPo {
    private String id;

    private String questionNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date publishTime;

    private String questionTitle;

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