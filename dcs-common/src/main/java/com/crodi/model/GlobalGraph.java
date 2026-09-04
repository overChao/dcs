package com.crodi.model;

import com.crodi.model.graph.Graph;
import lombok.Data;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/4 14:45
 * @Description: TODO
 **/

@Data
public class GlobalGraph {

    private String warehouseId;

    private List<Graph> graphs;

}
