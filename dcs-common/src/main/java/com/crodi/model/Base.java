package com.crodi.model;

import java.util.Date;

import lombok.Data;

@Data
public class Base {

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private boolean isActive;

    private boolean isDeleted;

}
