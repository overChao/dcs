package com.crodi.controller.base;

import com.crodi.base.WarehouseApi;
import com.crodi.exception.DcsSystemException;
import com.crodi.model.Warehouse;
import com.crodi.sys.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/3 13:27
 * @Description: TODO
 **/
@RestController
@RequestMapping("/base/warehouse")
@RequiredArgsConstructor
public class WarehouseManageController {

    private final WarehouseApi warehouseApi;

    @PostMapping("createWarehouse")
    public Result<?> createWarehouse(@RequestBody Warehouse warehouse) {
        try {
            warehouseApi.saveWarehouse(warehouse);
            return Result.ok();
        } catch (DcsSystemException e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("getWarehouse")
    public Result<?> getWarehouse(@RequestParam("warehouseId") String warehouseId) {
        try {
            return Result.success(warehouseApi.getWarehouseById(warehouseId));
        } catch (DcsSystemException e) {
            return Result.error(e.getMessage());
        }
    }
}
