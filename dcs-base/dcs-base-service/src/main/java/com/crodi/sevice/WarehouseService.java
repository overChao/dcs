package com.crodi.sevice;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.crodi.base.WarehouseApi;
import com.crodi.mapper.WarehouseMapper;
import com.crodi.model.graph.Warehouse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/8/12 16:52
 * @Description: TODO
 **/
@Service
@RequiredArgsConstructor
public class WarehouseService implements WarehouseApi {

    private final WarehouseMapper warehouseMapper;

    @Override
    public Warehouse getWarehouseById(String warehouseId) {
        Wrapper<Warehouse> wrapper = new LambdaQueryWrapper<Warehouse>()
                .eq(Warehouse::getWareHouseId, warehouseId)
                .eq(Warehouse::isDeleted, Boolean.FALSE)
                .eq(Warehouse::isActive, Boolean.TRUE);
        return warehouseMapper.selectOne(wrapper);
    }

    @Override
    public void saveWarehouse(Warehouse warehouse) {
        warehouseMapper.insert(warehouse);
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        Wrapper<Warehouse> wrapper = new LambdaQueryWrapper<Warehouse>()
                .eq(Warehouse::getWareHouseId, warehouse.getWareHouseId())
                .eq(Warehouse::isDeleted, Boolean.FALSE);
        warehouseMapper.update(warehouse, wrapper);
    }

    @Override
    public void deleteWarehouse(String warehouseId) {
        Wrapper<Warehouse> wrapper = new LambdaQueryWrapper<Warehouse>()
                .eq(Warehouse::getWareHouseId, warehouseId)
                .eq(Warehouse::isDeleted, Boolean.FALSE);
        Warehouse warehouse = new Warehouse();
        warehouse.setDeleted(Boolean.TRUE);
        warehouseMapper.update(warehouse, wrapper);
    }

    @Override
    public List<Warehouse> getWarehouseList() {
        Wrapper<Warehouse> wrapper = new LambdaQueryWrapper<Warehouse>()
                .eq(Warehouse::isDeleted, Boolean.FALSE);
        return warehouseMapper.selectList(wrapper);
    }

    @Override
    public Warehouse getActiveWarehouse() {
        Wrapper<Warehouse> wrapper = new LambdaQueryWrapper<Warehouse>()
                .eq(Warehouse::isDeleted, Boolean.FALSE)
                .eq(Warehouse::isActive, Boolean.TRUE);
        List<Warehouse> warehouseList = warehouseMapper.selectList(wrapper);

        if (warehouseList == null || warehouseList.isEmpty()) {
            return null;
        }

        if (warehouseList.size() > 1) {
            throw new IllegalArgumentException("Multiple active warehouses found");
        }

        return warehouseList.get(0);
    }
}
