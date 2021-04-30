package com.ask.qa_service.common;

import com.ask.qa_service.constant.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 通用返回实体类
 *
 * @author zhulongkun20@163.com
 * @since 2021/4/30 11:23 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseEntity<T> {

    private Integer code;

    private String message;

    private T data;

    public ResponseEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    public ResponseEntity(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
}
