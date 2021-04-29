# 问题内容表

DROP TABLE IF EXISTS `ask`.`ask_question_content`;

CREATE TABLE `ask`.`ask_question_content`
(
    `id`               VARCHAR(32) NOT NULL COMMENT '主键id',
    `question_no`      VARCHAR(15) NOT NULL DEFAULT 'Q19700101000000' COMMENT '问题编号',
    `question_content` LONGTEXT    NOT NULL COMMENT '问题内容',
    `created_by`       VARCHAR(50) NOT NULL DEFAULT '' COMMENT '创建者',
    `created_time`     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`       VARCHAR(50) NOT NULL DEFAULT '' COMMENT '更新者',
    `updated_time`     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8 COMMENT '问题内容表';