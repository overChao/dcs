package com.crodi.model.graph;

import com.baomidou.mybatisplus.annotation.TableName;
import com.crodi.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/15 11:17
 * @Description: 节点
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dcs_node")
public class Node extends BaseEntity {

    // 点位编码
    private String nodeCode;

    // 点位类型 路由点、邻接点
    private String nodeType;

    private String x;

    private String y;

    private String z;

    // 地图编码
    private String mapCode;
}
