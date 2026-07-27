package com.vlineup.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.vlineup.entity.mapEdtior.MapBarrier;
import com.vlineup.entity.mapEdtior.MapPoint;
import com.vlineup.entity.mapEdtior.MapSkillBall;
import com.vlineup.service.MapEditorService;
import com.vlineup.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "地图编辑")
@RestController
@RequestMapping("/mapEditor")
public class MapEditorController {

    @Resource
    private MapEditorService mapEditorService;

    @Operation(summary = "插入或更新")
    @PostMapping
    public Result save(@RequestBody String mapJson) {
        //将字符串转化为json对象
        JSONObject json = JSON.parseObject(mapJson);
        //子json对象数组反序列化
        List<MapPoint> mapPointList = (List<MapPoint>) json.get("pointJson");
        List<MapBarrier> mapBarrierList = (List<MapBarrier>) json.get("barrierJson");
        List<MapSkillBall> mapSkillBallList = (List<MapSkillBall>) json.get("skillBallJson");
        mapEditorService.saveOrUpdateMapBarrier(mapBarrierList);
        mapEditorService.saveOrUpdateMapPoint(mapPointList);
        mapEditorService.saveOrUpdateMapSkillBall(mapSkillBallList);
        return Result.success();
    }

    @Operation(summary = "获取信息")
    @GetMapping
    public Result<Map> get(@RequestParam String mapId) {
        List<MapPoint> mapPointList = mapEditorService.getMapPointList(mapId);
        List<MapBarrier> mapBarrierList = mapEditorService.getMapBarrierList(mapId);
        List<MapSkillBall> mapSkillBallList = mapEditorService.getMapSkillBallList(mapId);
        Map<String, Object> mapResult = new HashMap<>();
        mapResult.put("pointList", mapPointList);
        mapResult.put("barrierList", mapBarrierList);
        mapResult.put("skillBallList", mapSkillBallList);
        return Result.success(mapResult);
    }

    @Operation(summary = "删除节点")
    @DeleteMapping
    public Result remove(@RequestParam String uuid, @RequestParam String editType) {
        String tableName;
        switch (editType) {
            case "text":
                tableName = "map_point";
                break;
            case "image":
                tableName = "map_skillball";
                break;
            case "attackRect":
            case "defendRect":
                tableName = "map_barrier";
                break;
            default:
                return Result.error("删除错误的类型");
        }
        mapEditorService.removeMapNode(uuid, tableName);
        return Result.success();
    }

}
