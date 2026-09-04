package com.crodi.model.graph;

import com.baomidou.mybatisplus.annotation.TableName;
import com.crodi.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/4 10:53
 * @Description: TODO
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dcs_edge")
public class Edge extends BaseEntity {

    private String mapCode;

    private String edgeId;

    private String fromNode;

    private String toNode;

    private int direction;

    private int edgeType;

}
