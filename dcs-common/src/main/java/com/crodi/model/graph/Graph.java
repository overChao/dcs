package com.crodi.model.graph;

import lombok.Data;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/4 10:47
 * @Description: TODO
 **/

@Data
public class Graph {

    private String warehouseId;

    private String mapCode;

    private String layerNo;

    private int floorNo;

    private List<Node> nodes;

    private List<Edge> edges;

}


