package com.ask.qa_service.common;

import com.ask.qa_service.constant.RoleEnum;

import java.lang.annotation.*;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/13 12:13 AM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionCheck {

    // 可以访问某个接口的权限集合
    RoleEnum[] roles();
}
