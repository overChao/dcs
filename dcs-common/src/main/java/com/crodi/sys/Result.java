package com.crodi.sys;

import com.crodi.exception.BusinessExceptionEnum;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/29 10:40
 * @Description: TODO
 **/
@Data
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private boolean success = Boolean.TRUE;

    private String message;

    private String code = "200";

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


    public static <T> Result<T> error(String code, String message) {
        return new Result<>(Boolean.FALSE, code, message);
    }

    public static <T> Result<T> error(BusinessExceptionEnum exceptionEnum) {
        return new Result<>(Boolean.FALSE, exceptionEnum.getCode(), exceptionEnum.getMessage());
    }


    public Result() {
    }

    public Result(T result) {
        this.result = result;
    }

    public Result(String message) {
        this.message = message;
    }


    public Result(boolean isSuccess, String message) {
        this.success = isSuccess;
        this.message = message;
    }

    public Result(boolean isSuccess, String code, String message) {
        this.success = isSuccess;
        this.code = code;
        this.message = message;
    }

}
