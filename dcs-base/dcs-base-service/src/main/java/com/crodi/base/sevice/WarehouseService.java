package com.crodi.base.sevice;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.crodi.base.WarehouseApi;
import com.crodi.exception.DcsSystemException;
import com.crodi.exception.ExceptionConst;
import com.crodi.mapper.WarehouseMapper;
import com.crodi.model.Warehouse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        Wrapper<Warehouse> wrapper = new LambdaQueryWrapper<Warehouse>()
                .eq(Warehouse::getWarehouseId, warehouseId)
                .eq(Warehouse::getDeleted, Boolean.FALSE);
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

            warehouseMapper.insert(warehouse);
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

            Wrapper<Warehouse> wrapper = new LambdaQueryWrapper<Warehouse>()
                    .eq(Warehouse::getWarehouseId, warehouse.getWarehouseId())
                    .eq(Warehouse::getDeleted, Boolean.FALSE);

            warehouseMapper.update(warehouse, wrapper);
        } catch (Exception e) {
            log.error(ExceptionConst.WAREHOUSE_UPDATE_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_UPDATE_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.WAREHOUSE_UPDATE_FAILED);
        }
    }

    @Override
    public void deleteWarehouse(String warehouseId) {
        Wrapper<Warehouse> wrapper = new LambdaQueryWrapper<Warehouse>()
                .eq(Warehouse::getWarehouseId, warehouseId)
                .eq(Warehouse::getDeleted, Boolean.FALSE);
        Warehouse warehouse = new Warehouse();
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
        Wrapper<Warehouse> wrapper = new LambdaQueryWrapper<Warehouse>()
                .eq(Warehouse::getProjectId, projectId)
                .eq(Warehouse::getDeleted, Boolean.FALSE);
        try {
            List<Warehouse> warehouseList = warehouseMapper.selectList(wrapper);
            if (warehouseList == null || warehouseList.isEmpty()) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_NOT_EXIST);
            }
            return warehouseList;
        } catch (Exception e) {
            log.error(ExceptionConst.WAREHOUSE_SELECT_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_SELECT_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.WAREHOUSE_SELECT_FAILED);
        }
    }

    @Override
    public Warehouse getActiveWarehouse(String projectId) {
        Wrapper<Warehouse> wrapper = new LambdaQueryWrapper<Warehouse>()
                .eq(Warehouse::getProjectId, projectId)
                .eq(Warehouse::getDeleted, Boolean.FALSE)
                .eq(Warehouse::getActive, Boolean.TRUE);
        try {

            List<Warehouse> warehouseList = warehouseMapper.selectList(wrapper);

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
