package com.ask.qa_service.constant;

import lombok.Getter;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/17 23:47
 */
@Getter
public enum RoleEnum {

    R_USER("R_USER", "普通用户"),

    R_ADMIN("R_ADMIN", "系统管理员"),

    R_TEST("R_TEST", "测试用户");

    private final String roleCode;

    private final String roleName;

    RoleEnum(String roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }
}
