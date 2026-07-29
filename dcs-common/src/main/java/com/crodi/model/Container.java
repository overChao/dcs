package com.crodi.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/28 16:21
 * @Description: TODO
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("dcs_container")
public class Container extends BaseEntity {

    // 容器编码
    private String containerCode;

    // 节点编码
    private String nodeCode;

    // 地图编码
    private String mapCode;


    // 设备编码
    private String deviceCode;

    // 长度
    private String length;

    // 宽度
    private String width;

    // 高度
    private String height;

    // 重量
    private String weight;

    public Container(String containerCode, String nodeCode, String mapCode) {
        this.containerCode = containerCode;
        this.nodeCode = nodeCode;
        this.mapCode = mapCode;
    }
}
