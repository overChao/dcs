package com.crodi.model.graph;

import com.crodi.model.Project;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/22 10:16
 * @Description: TODO
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class Warehouse extends Project {

    private String wareHouseId;

    private String wareHouseName;

}
