package com.nju.edu.util;

import com.nju.edu.constant.Response;
import com.nju.edu.constant.ServiceException;

/**
 * @author phoebegl
 * @Date 2019/1/21.
 */
public class ResponseFactory<T> {
    private static final int OK_CODE = 0;

    private ResponseFactory() {
    }

    public static <T> Response<T> okReponse(Object data) {
        return new Response(OK_CODE, data);
    }

    public static Response<String> errResponse(ServiceException e) {
        return new Response(e.getCode(), e.getMessage());
    }

    public static Response<String> errResponse(int errCode, String errMessage) {
        return new Response(errCode, errMessage);
    }

}
