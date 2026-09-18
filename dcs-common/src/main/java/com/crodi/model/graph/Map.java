package com.crodi.model.graph;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class Map {

    // 仓库id
    private String warehouseId;

    // 图编码 例如：CBK-FLOOR-01
    private String mapCode;

    // 图名称
    private String mapName;

    // 图层
    private String layerNo;

    // 楼层
    private int floorNo;

    @TableField(value = "is_active")
    private Boolean active;

}
