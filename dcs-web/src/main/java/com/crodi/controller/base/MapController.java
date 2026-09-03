package com.crodi.controller.base;

import com.crodi.base.MapApi;
import com.crodi.model.graph.Map;
import com.crodi.sys.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/23 13:46
 * @Description: TODO
 **/

@Slf4j
@RestController
@RequestMapping("/base/map")
@RequiredArgsConstructor
public class MapController {

    private final MapApi mapApi;

    @PostMapping("createMap")
    public Result<?> createMap(@RequestBody Map map) {
        try {
            mapApi.saveWarehouseMap(map);
            return Result.ok();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("getMaps")
    public Result<?> getMaps(@RequestParam("warehouseId") String warehouseId) {
        try {
            return Result.success(mapApi.getWarehouseMaps(warehouseId));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("deleteMap")
    public Result<?> deleteMap(@RequestParam("mapCode") String mapCode) {
        try {
            mapApi.deleteWarehouseMap(mapCode);
            return Result.ok();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("updateMap")
    public Result<?> updateMaps(@RequestBody Map map) {
        try {
            mapApi.updateWarehouseMap(map);
            return Result.ok();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }



}
