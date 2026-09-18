package com.crodi.model;

import java.util.Date;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/14 10:15
 * @Description: TODO
 **/
public interface BaseEntity {

    void setCreatedBy(String createdBy);

    String getCreatedBy();

    void setUpdatedBy(String updatedBy);

    String getUpdatedBy();

    void setUpdatedTime(Date updatedTime);

    Date getUpdatedTime();

    void setCreatedTime(Date createdTime);

    Date getCreatedTime();

    void setActive(Boolean active);

    Boolean getActive();

    void setDeleted(Boolean deleted);

    Boolean getDeleted();


}
