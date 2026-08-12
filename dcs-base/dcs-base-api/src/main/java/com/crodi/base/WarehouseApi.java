package com.crodi.base;

import com.crodi.model.graph.Warehouse;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/8/12 16:48
 * @Description: TODO
 **/
public interface WarehouseApi {

    Warehouse getWarehouseById(String warehouseId);

    void saveWarehouse(Warehouse warehouse);

    void updateWarehouse(Warehouse warehouse);

//    void deleteWarehouse(String warehouseId);

    List<Warehouse> getWarehouseList();

}
