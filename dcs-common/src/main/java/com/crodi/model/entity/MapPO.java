package com.crodi.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.crodi.model.BaseEntity;
import com.crodi.model.graph.Map;

import java.util.Date;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/18
 * @Description: 地图持久化对象，承载审计字段
 **/
@TableName("dcs_map")
public class MapPO extends Map implements BaseEntity {

    private String createdBy;

    private String updatedBy;

    private Date createdTime;

    private Date updatedTime;

    @TableField(value = "is_deleted")
    private Boolean deleted;

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public Date getUpdatedTime() {
        return updatedTime;
    }

    @Override
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public Date getCreatedTime() {
        return createdTime;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public Boolean getDeleted() {
        return deleted;
    }
}
