package com.crodi.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class BaseEntity {

    private String createdBy;

    private String updatedBy;

    private Date createdTime;

    private Date updatedTime;

    @TableField(value = "is_active")
    private boolean active;

    @TableField(value = "is_deleted")
    private boolean deleted;

}
