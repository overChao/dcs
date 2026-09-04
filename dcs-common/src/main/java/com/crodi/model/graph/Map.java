package com.crodi.model.graph;

import com.baomidou.mybatisplus.annotation.TableName;
import com.crodi.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/15 11:15
 * @Description: 仓库布局图
 **/


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("dcs_map")
public class Map extends BaseEntity {

    // 仓库id
    private String warehouseId;

    // 图编码
    private String mapCode;

    // 图名称
    private String mapName;

    // 图层
    private String layerNo;

    // 楼层
    private int floorNo;

    public Map(String mapCode, String layerNo, int floorNo) {
        this.mapCode = mapCode;
        this.layerNo = layerNo;
        this.floorNo = floorNo;
    }

}
