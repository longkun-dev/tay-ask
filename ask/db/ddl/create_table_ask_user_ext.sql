# 用户信息表

DROP TABLE IF EXISTS `ask`.`ask_user_ext`;

CREATE TABLE `ask`.`ask_user_ext`
(
    `id`               VARCHAR(32) NOT NULL COMMENT '主键id',
    `user_id`          VARCHAR(30) NOT NULL COMMENT '用户id',
    `gold_badges`      INT         NOT NULL DEFAULT 0 COMMENT '金牌数',
    `silver_badges`    INT         NOT NULL DEFAULT 0 COMMENT '银牌数',
    `bronze_badges`    INT         NOT NULL DEFAULT 0 COMMENT '铜牌数',
    `reputation_score` INT         NOT NULL DEFAULT 0 COMMENT '声誉分',
    `created_by`       VARCHAR(50) NOT NULL DEFAULT '' COMMENT '创建者',
    `created_time`     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`       VARCHAR(50) NOT NULL DEFAULT '' COMMENT '更新者',
    `updated_time`     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8 COMMENT '用户信息表';