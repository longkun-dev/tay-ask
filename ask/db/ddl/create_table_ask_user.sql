# 用户表

DROP TABLE IF EXISTS `ask`.`ask_user`;

CREATE TABLE `ask`.`ask_user`
(
    `id`              VARCHAR(32) NOT NULL COMMENT '主键id',
    `user_id`         VARCHAR(30) NOT NULL COMMENT '用户id',
    `username`        VARCHAR(50) NOT NULL DEFAULT '无名之辈' COMMENT '用户名',
    `password`        VARCHAR(25) NOT NULL DEFAULT '123456' COMMENT '登录密码',
    `role`            VARCHAR(30) NOT NULL DEFAULT 'DEFAULT' COMMENT '用户角色',
    `last_login_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次登录时间',
    `created_by`      VARCHAR(50) NOT NULL DEFAULT '' COMMENT '创建者',
    `created_time`    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`      VARCHAR(50) NOT NULL DEFAULT '' COMMENT '更新者',
    `updated_time`    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8 COMMENT '用户信息表';
