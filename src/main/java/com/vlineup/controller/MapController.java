package com.vlineup.controller;

import com.vlineup.entity.Map_;
import com.vlineup.service.MapService;
import com.vlineup.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "地图")
@RestController
@RequestMapping("/map")
public class MapController {

    @Resource
    private MapService mapService;

    @Operation(summary = "获取所有地图信息")
    @GetMapping
    public Result<List<Map_>> getMapList() {
        return Result.success(mapService.getMapList());
    }
}
