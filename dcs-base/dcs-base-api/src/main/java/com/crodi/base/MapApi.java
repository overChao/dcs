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
    List<Map> getWarehouseMaps(String warehouseId);

    /**
     * 获取仓库地图
     *
     * @param mapCode 地图编码
     * @return 地图
     */
    Map getWarehouseMap(String mapCode);

    /**
     * 保存仓库地图
     *
     * @param map 地图
     */
    void saveWarehouseMap(Map map);


    /**
     * 删除仓库地图
     *
     * @param mapCode 地图编码
     */
    void deleteWarehouseMap(String mapCode);

    /**
     * 更新仓库地图
     *
     * @param map 地图
     */
    void updateWarehouseMap(Map map);


}
