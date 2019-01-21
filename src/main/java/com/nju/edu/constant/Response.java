package com.nju.edu.constant;

import lombok.Data;

/**
 * @author phoebegl
 * @Date 2019/1/21.
 */
@Data
public class Response<T> {
    /**
     * 数据
     */
    private T res;
    /**
     * 状态码
     */
    private int code;

    public Response(int code, T res) {
        this.res = res;
        this.code = code;
    }
}
