package com.ask.qa_service.common;

import com.ask.qa_service.constant.ResultEnum;

/**
 * 通用返回工具类
 *
 * @author zhulongkun20@163.com
 * @since 2021/4/30 11:23 PM
 */
public class ResponseUtils {

    public static <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(),
                data);
    }

    public static <T> ResponseEntity<T> success() {
        return new ResponseEntity<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
    }

//    public static <T> ResponseEntity<T> success(String message) {
//        return new ResponseEntity<>(ResultEnum.SUCCESS.getCode(), message);
//    }

    public static <T> ResponseEntity<T> success(String message, T data) {
        return new ResponseEntity<>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> ResponseEntity<T> success(ResultEnum resultEnum, T data) {
        return new ResponseEntity<>(resultEnum, data);
    }

    public static <T> ResponseEntity<T> error(String message) {
        return new ResponseEntity<>(ResultEnum.ERROR.getCode(), message);
    }

    public static <T> ResponseEntity<T> error() {
        return new ResponseEntity<>(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage());
    }

    public static <T> ResponseEntity<T> error(ResultEnum resultEnum) {
        return new ResponseEntity<>(resultEnum);
    }
}
