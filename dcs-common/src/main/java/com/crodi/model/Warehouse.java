package com.crodi.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/22 10:16
 * @Description: TODO
 **/

@Data
public class Warehouse {

    private String warehouseId;

    private String warehouseName;

    private String projectId;

    @TableField(value = "is_active")
    private Boolean active;

}
