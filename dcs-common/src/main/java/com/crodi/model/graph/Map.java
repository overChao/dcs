package com.crodi.model.graph;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/15 11:15
 * @Description: TODO
 **/


@Data
@EqualsAndHashCode(callSuper = false)
public class Map extends Warehouse {

    // 图编码
    private String mapCode;

    // 图名称
    private String mapName;

    // 层id
    private String layerCode;

    public Map(String mapCode, String layerCode) {
        this.mapCode = mapCode;
        this.layerCode = layerCode;
    }

}
