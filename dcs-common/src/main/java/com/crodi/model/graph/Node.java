package com.crodi.model.graph;

import com.baomidou.mybatisplus.annotation.TableName;
import com.crodi.util.NodeCodeUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/15 11:17
 * @Description: 节点
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dcs_node")
@AllArgsConstructor
@NoArgsConstructor
public class Node {

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


    public Node(String warehouseId, String mapCode, int x, int y, int z, int cowNo, int colNo, int levelNo) {
        this.warehouseId = warehouseId;
        this.mapCode = mapCode;
        this.x = x;
        this.y = y;
        this.z = z;
        this.cowNo = cowNo;
        this.colNo = colNo;
        this.levelNo = levelNo;

        this.nodeCode = NodeCodeUtil.generate(this);
    }

    public Node(String warehouseId, String mapCode, int cowNo, int colNo, int levelNo) {
        this.warehouseId = warehouseId;
        this.mapCode = mapCode;

        this.cowNo = cowNo;
        this.colNo = colNo;
        this.levelNo = levelNo;

        this.nodeCode = NodeCodeUtil.generate(this);
    }


}
