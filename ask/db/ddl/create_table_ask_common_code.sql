DROP TABLE IF EXISTS `try_ask`.`common_code`;

CREATE TABLE `try_ask`.`common_code`
(
    `id`           VARCHAR(32)  NOT NULL COMMENT '主键',
    `code_name`    VARCHAR(100) NOT NULL COMMENT '名称',
    `code_value`   VARCHAR(100) NOT NULL COMMENT '值',
    `remark`       VARCHAR(255) NOT NULL DEFAULT '无' COMMENT '备注',
    `created_by`   VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '创建者',
    `created_time` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`   VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '更新者',
    `updated_time` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '基础变量表';