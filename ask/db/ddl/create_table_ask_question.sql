# 问题信息表

DROP TABLE IF EXISTS `ask`.`ask_question`;

CREATE TABLE `ask`.`ask_question`
(
    `id`               VARCHAR(32)  NOT NULL COMMENT '主键id',
    `question_no`      VARCHAR(15)  NOT NULL DEFAULT 'Q19700101000000' COMMENT '问题编号',
    `publish_time`     DATETIME              DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
    `question_content` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '问题内容',
    `votes`            INT          NOT NULL DEFAULT 0 COMMENT '投票数',
    `answers`          INT          NOT NULL DEFAULT 0 COMMENT '回答数',
    `views`            INT          NOT NULL DEFAULT 0 COMMENT '被浏览次数',
    `tags`             VARCHAR(120) NOT NULL DEFAULT '' COMMENT '问题标签',
    `asked_by`         VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '提问者',
    `created_by`       VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '创建者',
    `created_time`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`       VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '更新者',
    `updated_time`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8 COMMENT '问题信息表';