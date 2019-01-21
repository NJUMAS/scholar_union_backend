package com.nju.edu.constant;

/**
 * 错误码约束
 * @author phoebegl
 * @Date 2019/1/21.
 */
public enum ErrorEnum {

    EXAMPLE(1001, "示例错误码");

    private final int errCode;
    private final String errMessage;

    ErrorEnum(int errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMessage() {
        return this.errMessage;
    }
}
