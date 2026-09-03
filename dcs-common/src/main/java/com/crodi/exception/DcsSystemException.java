package com.crodi.exception;

/**
 * @Author: crodi.zhang
 * @Date: 2026/8/20 10:39
 * @Description: 系统异常
 **/
public class DcsSystemException extends RuntimeException {


    public DcsSystemException(String message) {
        super(message);
    }

    public DcsSystemException(String... messages) {
        super(String.join(",", messages));
    }


    public DcsSystemException(String message, Throwable cause) {
        super(message, cause);
    }

}
