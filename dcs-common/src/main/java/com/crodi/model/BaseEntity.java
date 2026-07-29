package com.crodi.model;

import java.util.Date;

import lombok.Data;

@Data
public class BaseEntity {

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private boolean isActive;

    private boolean isDeleted;

}
