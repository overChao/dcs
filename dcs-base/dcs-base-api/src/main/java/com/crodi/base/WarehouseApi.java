package com.crodi.base;

import com.crodi.model.graph.Warehouse;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/8/12 16:48
 * @Description: TODO
 **/
public interface WarehouseApi {

    /**
     * 根据仓库ID获取仓库
     *
     * @param warehouseId 仓库ID
     * @return warehouse
     */
    Warehouse getWarehouseById(String warehouseId);

    /**
     * 保存仓库
     *
     * @param warehouse 仓库
     */
    void saveWarehouse(Warehouse warehouse);

    /**
     * 更新仓库
     *
     * @param warehouse 仓库
     */
    void updateWarehouse(Warehouse warehouse);

    /**
     * 删除仓库
     *
     * @param warehouseId 仓库ID
     */
    void deleteWarehouse(String warehouseId);

    /**
     * 获取仓库列表
     *
     * @return warehouseList
     */
    List<Warehouse> getWarehouseList();

    /**
     * 获取当前激活的仓库
     *
     * @return warehouse
     */
    Warehouse getActiveWarehouse();

}
