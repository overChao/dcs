package com.crodi.model.graph;

import com.baomidou.mybatisplus.annotation.TableName;
import com.crodi.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/15 11:17
 * @Description: 节点
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dcs_node")
public class Node extends BaseEntity {

    // 仓库id
    private String warehouseId;

    // 地图编码
    private String mapCode;

    // 点位编码
    private String nodeCode;

    // 点位类型 路由点
    private String nodeType;

    // x坐标
    private int x;

    // y坐标
    private int y;

    // z坐标
    private int z;

    // 行
    private int cowNo;

    // 列
    private int colNo;

    // 层
    private int levelNo;

    // 关联设备类型
    private List<String> deviceTypes;

}
