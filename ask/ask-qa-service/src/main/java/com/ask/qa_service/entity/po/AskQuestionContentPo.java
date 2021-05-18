package com.ask.qa_service.entity.po;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "问题内容实体类")
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