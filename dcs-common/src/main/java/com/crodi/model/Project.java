package com.crodi.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/1 13:35
 * @Description: TODO
 **/


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dcs_project")
public class Project extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 项目编码
    private String projectId;

    // 项目名称
    private String projectName;

    // 项目描述
    private String projectDesc;


}
