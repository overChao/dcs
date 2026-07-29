package com.crodi.model.graph;

import com.crodi.model.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/22 10:16
 * @Description: TODO
 **/

@Data
@EqualsAndHashCode(callSuper = true)
public class Warehouse extends BaseEntity {

    private String wareHouseId;

    private String wareHouseName;

}
