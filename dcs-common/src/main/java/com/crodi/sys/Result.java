package com.crodi.sys;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/29 10:40
 * @Description: TODO
 **/
public class Result<T> {

    private boolean success = Boolean.TRUE;

    private String message;

    private Integer code = 200;

    private T result;

    public static <T> Result<T> ok() {
        return new Result<>();
    }

    public static <T> Result<T> success(T result) {
        return new Result<>(result);
    }


    public static <T> Result<T> error(String message) {
        return new Result<>(Boolean.FALSE, message);
    }


    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(Boolean.FALSE, code, message);
    }


    public Result() {
    }

    public Result(T result) {
        this.result = result;
    }


    public Result(boolean isSuccess, String message) {
        this.success = isSuccess;
        this.message = message;
    }

    public Result(boolean isSuccess, Integer code, String message) {
        this.success = isSuccess;
        this.code = code;
        this.message = message;
    }

}
