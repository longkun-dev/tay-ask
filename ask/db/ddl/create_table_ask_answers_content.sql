# 答案内容表

DROP TABLE IF EXISTS `ask`.`ask_answers_content`;

CREATE TABLE `ask`.`ask_answers_content`
(
    `id`              VARCHAR(32) NOT NULL COMMENT '主键id',
    `question_no`     VARCHAR(15) NOT NULL DEFAULT 'Q19700101000000' COMMENT '问题编号',
    `order_no`        VARCHAR(5)  NOT NULL DEFAULT '0' COMMENT '答案序号',
    `answer_no`       VARCHAR(15) NOT NULL DEFAULT 'A19700101000000' COMMENT '答案编号',
    `answers_content` LONGTEXT    NOT NULL COMMENT '问题内容',
    `answered_by`     VARCHAR(50) NOT NULL DEFAULT '' COMMENT '答案内容',
    `votes`           INT         NOT NULL DEFAULT 0 COMMENT '得票数',
    `publish_time`    DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
    `created_by`      VARCHAR(50) NOT NULL DEFAULT '' COMMENT '创建者',
    `created_time`    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`      VARCHAR(50) NOT NULL DEFAULT '' COMMENT '更新者',
    `updated_time`    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8 COMMENT '答案内容表';