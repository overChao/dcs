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

    // 图编码
    private String mapCode;

    // 图名称
    private String mapName;

    // 层id
    private String layerCode;

    // 仓库id
    private String warehouseId;

    public Map(String mapCode, String layerCode) {
        this.mapCode = mapCode;
        this.layerCode = layerCode;
    }

}
