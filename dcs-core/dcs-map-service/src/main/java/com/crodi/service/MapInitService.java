package com.crodi.service;

import com.crodi.base.WarehouseApi;
import com.crodi.model.graph.Map;
import com.crodi.model.Warehouse;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/8/7 15:19
 * @Description: TODO
 **/


@Slf4j
@Service
@RequiredArgsConstructor
public class MapInitService {


    private final WarehouseApi warehouseApi;

    //
    //  默认前缀、 业务分区前缀、
    //  图编码格式 MAP_CP_01
    //  最大层数、 5

    private static final String default_prefix = "MAP_";




    public Warehouse loadWarehouse() {
        return null;
    }


    public List<Map> initMap(String businessArea, int layerSize) {
        List<Map> mapList = Lists.newArrayList();
        for (int i = 1; i <= layerSize; i++) {
            String mapCode = default_prefix + businessArea + "_" + i;
            mapList.add(new Map(mapCode, String.valueOf(i)));
        }
        return mapList;
    }

    // TODO  crodi.zhang  2026/8/20: 仓库编码和仓库名称 构造器

}
