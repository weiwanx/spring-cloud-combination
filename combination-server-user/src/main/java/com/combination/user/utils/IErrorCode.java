package com.combination.user.utils;

/**
 * @author weiwanxi
 * 封装API的错误码
 */
public interface IErrorCode {

    /**
     * 获取状态码
     *
     * @return
     */
    long getCode();

    /**
     * 获取返回值
     *
     * @return
     */
    String getMessage();
}
