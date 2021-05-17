package com.ask.qa_service.exception;

import com.ask.qa_service.constant.ResultEnum;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/14 11:52 PM
 */
public class AskException extends Exception {

    private Integer code;

    private String message;

    public AskException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public AskException(String message) {
        super(message);
        this.code = ResultEnum.ERROR.getCode();
    }
}
