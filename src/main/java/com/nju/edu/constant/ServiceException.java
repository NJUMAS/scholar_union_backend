package com.nju.edu.constant;

import lombok.Data;

/**
 * 封装逻辑层自定义异常, 返回前端是状态码为200的消息
 * @author phoebegl
 * @Date 2019/1/21.
 */
@Data
public class ServiceException extends RuntimeException {
    private int code;
    private String message;

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ServiceException(ErrorEnum err) {
        super(err.getErrMessage());
        this.code = err.getErrCode();
        this.message = err.getErrMessage();
    }
}