package com.crodi.base.sevice;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.crodi.base.MapApi;
import com.crodi.exception.DcsSystemException;
import com.crodi.exception.ExceptionConst;
import com.crodi.mapper.MapMapper;
import com.crodi.model.entity.MapPO;
import com.crodi.model.graph.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        Wrapper<MapPO> wrapper = new LambdaQueryWrapper<MapPO>()
                .eq(MapPO::getWarehouseId, warehouseId)
                .eq(MapPO::getDeleted, Boolean.FALSE);
        try {
            List<MapPO> maps = mapMapper.selectList(wrapper);

            if (maps == null || maps.isEmpty()) {
                throw new DcsSystemException(ExceptionConst.MAP_NOT_EXIST);
            }
            return new ArrayList<>(maps);
        } catch (Exception e) {
            log.error(ExceptionConst.MAP_SELECT_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.MAP_SELECT_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.MAP_SELECT_FAILED);
        }
    }

    @Override
    public Map getWarehouseMap(String mapCode) {
        Wrapper<MapPO> wrapper = new LambdaQueryWrapper<MapPO>()
                .eq(MapPO::getMapCode, mapCode)
                .eq(MapPO::getDeleted, Boolean.FALSE);
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
            validateWarehouseMap(map);

            mapMapper.insert((MapPO) map);
        } catch (Exception e) {
            log.error(ExceptionConst.MAP_CREATE_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.MAP_CREATE_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.MAP_CREATE_FAILED);
        }

    }

    @Override
    public void deleteWarehouseMap(String mapCode) {

        try {
            LambdaUpdateWrapper<MapPO> wrapper = new LambdaUpdateWrapper<MapPO>()
                    .eq(MapPO::getMapCode, mapCode)
                    .eq(MapPO::getDeleted, Boolean.FALSE)
                    .set(MapPO::getDeleted, Boolean.TRUE);
            mapMapper.update(wrapper);
        } catch (Exception e) {
            log.error(ExceptionConst.MAP_DELETE_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.MAP_DELETE_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.MAP_DELETE_FAILED);
        }


    }

    @Override
    public void updateWarehouseMap(Map map) {
        try {

            if (map == null) {
                throw new DcsSystemException(ExceptionConst.REQUEST_PARAM_NOT_NULL);
            }

            MapPO mapPO = (MapPO) map;

            if (mapPO.getMapCode() == null) {
                throw new DcsSystemException(ExceptionConst.MAP_CODE_NOT_NULL);
            }

            LambdaUpdateWrapper<MapPO> wrapper = new LambdaUpdateWrapper<MapPO>()
                    .eq(MapPO::getMapCode, mapPO.getMapCode())
                    .eq(MapPO::getDeleted, Boolean.FALSE);

            if (Objects.nonNull(mapPO.getMapName())) {
                wrapper.set(MapPO::getMapName, mapPO.getMapName());
            }

            if (Objects.nonNull(mapPO.getLayerNo())) {
                wrapper.set(MapPO::getLayerNo, mapPO.getLayerNo());
            }

            if (Objects.nonNull(mapPO.getActive())) {
                wrapper.set(MapPO::getActive, mapPO.getActive());
            }

            mapMapper.update(mapPO, wrapper);

        } catch (Exception e) {
            log.error(ExceptionConst.MAP_UPDATE_FAILED, e);
            if (e instanceof DcsSystemException) {
                throw new DcsSystemException(ExceptionConst.MAP_UPDATE_FAILED, e.getMessage());
            } else throw new DcsSystemException(ExceptionConst.MAP_UPDATE_FAILED);
        }


    }


    public void validateWarehouseMap(Map map) {
        if (map == null) {
            throw new DcsSystemException(ExceptionConst.REQUEST_PARAM_NOT_NULL);
        }

        if (map.getWarehouseId() == null) {
            throw new DcsSystemException(ExceptionConst.WAREHOUSE_ID_NOT_NULL);
        }

        if (map.getMapCode() == null) {
            throw new DcsSystemException(ExceptionConst.MAP_CODE_NOT_NULL);
        }
    }

}
