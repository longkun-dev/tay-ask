package com.ask.qa_service.constant;

import lombok.Getter;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/30 11:27 PM
 */
@Getter
public enum ResultEnum {

    SUCCESS(200, "请求成功"),

    ERROR(500, "请求失败"),

    BAD_REQUEST(400, "错误的请求"),

    NO_PERMISSION(401, "无访问权限");

    Integer code;

    String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
