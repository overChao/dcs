package com.crodi.sevice;

import com.crodi.base.MapApi;
import com.crodi.model.graph.Map;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/24 9:38
 * @Description: TODO
 **/
@Service
public class MapService implements MapApi {

    @Override
    public List<Map> getWarehouseMap() {
        return List.of();
    }

    @Override
    public Map getWarehouseMap(String mapId) {
        return null;
    }

    @Override
    public void saveWarehouseMap(Map map) {

    }
}
