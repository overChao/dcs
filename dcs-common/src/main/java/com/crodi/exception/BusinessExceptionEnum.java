package com.crodi.exception;

import lombok.Getter;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/2 15:14
 * @Description: 业务异常枚举
 **/
@Getter
public enum BusinessExceptionEnum {


    ;

    private final String code;

    private final String message;

    BusinessExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
