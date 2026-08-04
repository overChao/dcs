package com.crodi.base;

import com.crodi.model.graph.Map;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/24 9:34
 * @Description: TODO
 **/

public interface MapApi {

    /**
     * 获取仓库地图列表
     *
     * @return 地图列表
     */
    List<Map> getWarehouseMap();

    /**
     * 获取仓库地图
     *
     * @param mapId 地图ID
     * @return 地图
     */
    Map getWarehouseMap(String mapId);


    void saveWarehouseMap(Map map);


}
