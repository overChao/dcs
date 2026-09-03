package com.crodi.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/22 10:16
 * @Description: TODO
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dcs_warehouse")
public class Warehouse extends BaseEntity {

    private String warehouseId;

    private String warehouseName;

    private String projectId;

}
