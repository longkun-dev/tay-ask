# 答案评论

DROP TABLE IF EXISTS `ask`.`ask_answers_comment`;

CREATE TABLE `ask`.`ask_answers_comment`
(
    `id`              VARCHAR(32)  NOT NULL COMMENT '主键id',
    `answer_no`       VARCHAR(15)  NOT NULL DEFAULT 'A19700101000000' COMMENT '答案编号',
    `comment_no`      VARCHAR(15)  NOT NULL DEFAULT 'C19700101000000' COMMENT '评论编号',
    `order_no`        VARCHAR(5)   NOT NULL DEFAULT '0' COMMENT '排序字段',
    `comment_content` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '评论内容',
    `created_by`      VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '创建者',
    `created_time`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`      VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '更新者',
    `updated_time`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8 COMMENT '答案评论表';