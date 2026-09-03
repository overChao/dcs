package com.crodi.controller.base;

import com.crodi.base.MapApi;
import com.crodi.model.graph.Map;
import com.crodi.sys.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
