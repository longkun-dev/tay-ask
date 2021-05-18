package com.ask.qa_service.entity.po;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "答案评论实体类")
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