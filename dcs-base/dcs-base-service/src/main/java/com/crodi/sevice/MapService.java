package com.crodi.sevice;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.crodi.base.MapApi;
import com.crodi.exception.DcsSystemException;
import com.crodi.exception.ExceptionConst;
import com.crodi.mapper.MapMapper;
import com.crodi.model.graph.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/24 9:38
 * @Description: TODO
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class MapService implements MapApi {

    private final MapMapper mapMapper;

    @Override
    public List<Map> getWarehouseMaps(String warehouseId) {
        Wrapper<Map> wrapper = new LambdaQueryWrapper<Map>()
                .eq(Map::getWarehouseId, warehouseId)
                .eq(Map::isDeleted, Boolean.FALSE);
        try {
            List<Map> maps = mapMapper.selectList(wrapper);

            if (maps == null || maps.isEmpty()) {
                throw new DcsSystemException(ExceptionConst.MAP_NOT_EXIST);
            }
            return maps;
        } catch (Exception e) {
            log.error(ExceptionConst.MAP_SELECT_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.MAP_SELECT_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.MAP_SELECT_FAILED);
        }
    }

    @Override
    public Map getWarehouseMap(String mapCode) {
        Wrapper<Map> wrapper = new LambdaQueryWrapper<Map>()
                .eq(Map::getMapCode, mapCode)
                .eq(Map::isDeleted, Boolean.FALSE);
        try {
            Map map = mapMapper.selectOne(wrapper);
            if (map == null) {
                throw new DcsSystemException(ExceptionConst.MAP_NOT_EXIST);
            }
            return map;
        } catch (Exception e) {
            log.error(ExceptionConst.MAP_SELECT_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.MAP_SELECT_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.MAP_SELECT_FAILED);
        }
    }

    @Override
    public void saveWarehouseMap(Map map) {
        try {
            if (map == null) {
                throw new DcsSystemException(ExceptionConst.REQUEST_PARAM_NOT_NULL);
            }

            if (map.getWarehouseId() == null) {
                throw new DcsSystemException(ExceptionConst.WAREHOUSE_ID_NOT_NULL);
            }

            if (map.getMapCode() == null) {
                throw new DcsSystemException(ExceptionConst.MAP_CODE_NOT_NULL);
            }
            mapMapper.insert(map);
        } catch (Exception e) {
            log.error(ExceptionConst.MAP_CREATE_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.MAP_CREATE_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.MAP_CREATE_FAILED);
        }

    }
}
