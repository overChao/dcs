package com.crodi.model.device;

import com.crodi.model.graph.Node;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/22 15:17
 * @Description: TODO
 **/

@Data
@EqualsAndHashCode(callSuper = true)
public class Conveyor extends Device {

    private String pointCode;

    private Node node;

}
