package com.crodi.base.sevice;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.crodi.base.WarehouseApi;
import com.crodi.exception.DcsSystemException;
import com.crodi.exception.ExceptionConst;
import com.crodi.mapper.WarehouseMapper;
import com.crodi.model.Warehouse;
import com.crodi.model.entity.WarehousePO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/8/12 16:52
 * @Description: TODO
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseService implements WarehouseApi {

    private final WarehouseMapper warehouseMapper;

    @Override
    public Warehouse getWarehouseById(String warehouseId) {
        Wrapper<WarehousePO> wrapper = new LambdaQueryWrapper<WarehousePO>()
                .eq(WarehousePO::getWarehouseId, warehouseId)
                .eq(WarehousePO::getDeleted, Boolean.FALSE);
        try {
            Warehouse warehouse = warehouseMapper.selectOne(wrapper);
            if (warehouse == null) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_NOT_EXIST);
            }
            return warehouse;
        } catch (Exception e) {
            log.error(ExceptionConst.WAREHOUSE_SELECT_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_SELECT_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.WAREHOUSE_SELECT_FAILED);
        }
    }

    @Override
    public void saveWarehouse(Warehouse warehouse) {
        try {

            validateWarehouse(warehouse);

            warehouseMapper.insert((WarehousePO) warehouse);
        } catch (Exception e) {
            log.error(ExceptionConst.WAREHOUSE_CREATE_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_CREATE_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.WAREHOUSE_CREATE_FAILED);
        }
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {

        try {
            validateWarehouse(warehouse);

            Wrapper<WarehousePO> wrapper = new LambdaQueryWrapper<WarehousePO>()
                    .eq(WarehousePO::getWarehouseId, warehouse.getWarehouseId())
                    .eq(WarehousePO::getDeleted, Boolean.FALSE);

            warehouseMapper.update((WarehousePO) warehouse, wrapper);
        } catch (Exception e) {
            log.error(ExceptionConst.WAREHOUSE_UPDATE_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_UPDATE_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.WAREHOUSE_UPDATE_FAILED);
        }
    }

    @Override
    public void deleteWarehouse(String warehouseId) {
        Wrapper<WarehousePO> wrapper = new LambdaQueryWrapper<WarehousePO>()
                .eq(WarehousePO::getWarehouseId, warehouseId)
                .eq(WarehousePO::getDeleted, Boolean.FALSE);
        WarehousePO warehouse = new WarehousePO();
        warehouse.setDeleted(Boolean.TRUE);
        try {
            warehouseMapper.update(warehouse, wrapper);
        } catch (Exception e) {
            log.error(ExceptionConst.WAREHOUSE_DELETE_FAILED, e);
            throw new DcsSystemException(ExceptionConst.WAREHOUSE_DELETE_FAILED);
        }
    }

    @Override
    public List<Warehouse> getWarehouseList(String projectId) {
        Wrapper<WarehousePO> wrapper = new LambdaQueryWrapper<WarehousePO>()
                .eq(WarehousePO::getProjectId, projectId)
                .eq(WarehousePO::getDeleted, Boolean.FALSE);
        try {
            List<WarehousePO> warehouseList = warehouseMapper.selectList(wrapper);
            if (warehouseList == null || warehouseList.isEmpty()) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_NOT_EXIST);
            }
            return new ArrayList<>(warehouseList);
        } catch (Exception e) {
            log.error(ExceptionConst.WAREHOUSE_SELECT_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_SELECT_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.WAREHOUSE_SELECT_FAILED);
        }
    }

    @Override
    public Warehouse getActiveWarehouse(String projectId) {
        Wrapper<WarehousePO> wrapper = new LambdaQueryWrapper<WarehousePO>()
                .eq(WarehousePO::getProjectId, projectId)
                .eq(WarehousePO::getDeleted, Boolean.FALSE)
                .eq(WarehousePO::getActive, Boolean.TRUE);
        try {

            List<WarehousePO> warehouseList = warehouseMapper.selectList(wrapper);

            if (warehouseList == null || warehouseList.isEmpty()) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_NOT_EXIST);
            }

            if (warehouseList.size() > 1) {
                throw new DcsSystemException(ExceptionConst.MULTIPLE_ACTIVE_WAREHOUSE_FOUND);
            }

            return warehouseList.get(0);
        } catch (Exception e) {
            log.error(ExceptionConst.WAREHOUSE_SELECT_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_SELECT_FAILED, e.getMessage());
            }
            throw new DcsSystemException(ExceptionConst.WAREHOUSE_SELECT_FAILED);
        }
    }


    private void validateWarehouse(Warehouse warehouse) {

        if (warehouse == null) {
            throw new DcsSystemException(ExceptionConst.WAREHOUSE_ID_NOT_NULL);
        }

        if (warehouse.getProjectId() == null) {
            throw new DcsSystemException(ExceptionConst.PROJECT_ID_NOT_NULL);
        }

        if (warehouse.getWarehouseId() == null) {
            throw new DcsSystemException(ExceptionConst.WAREHOUSE_ID_NOT_NULL);
        }
    }


}
