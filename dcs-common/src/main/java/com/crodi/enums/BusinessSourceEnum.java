package com.crodi.enums;

import lombok.Getter;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/29 11:34
 * @Description: TODO
 **/
@Getter
public enum BusinessSourceEnum {

    wcs("WCS", "仓储控制系统"),

    mes("MES", "制造执行系统"),

    wms("WMS", "仓储管理系统"),

    ;

    private final String code;

    private final String desc;

    BusinessSourceEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
