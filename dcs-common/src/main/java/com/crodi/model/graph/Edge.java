package com.crodi.model.graph;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/4 10:53
 * @Description: TODO
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class Edge {

    private String mapCode;

    private String edgeId;

    private String fromNode;

    private String toNode;

    private int direction;

    private int edgeType;

    @TableField(value = "is_active")
    private Boolean isActive;

}
