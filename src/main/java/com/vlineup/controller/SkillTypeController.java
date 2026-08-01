package com.vlineup.controller;

import com.vlineup.entity.skillType.LineSkill;
import com.vlineup.entity.skillType.ThrowSkill;
import com.vlineup.service.SkillTypeService;
import com.vlineup.utils.Result;
import com.vlineup.utils.ThreadLocalUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "技能位置数据")
@RestController
@RequestMapping
public class SkillTypeController {

    @Resource
    private SkillTypeService skillTypeService;

    //#region ThrowSKill
    @Operation(summary = "抛掷技能插入")
    @PostMapping("/throwSkill")
    public Result saveThrowSkill(@RequestBody ThrowSkill throwSkill) {
        skillTypeService.saveThrowSkill(throwSkill);
        return Result.success();
    }

    @Operation(summary = "抛掷技能查询")
    @GetMapping("/throwSkill")
    public Result<List<ThrowSkill>> getThrowSkill(@RequestParam String mapId, @RequestParam String agentId, @RequestParam String skillIndex, @RequestParam String side) {
        List<ThrowSkill> throwSkill = skillTypeService.getThrowSkillList(mapId, agentId, skillIndex, side);
        return Result.success(throwSkill);
    }

    @Operation(summary = "抛掷技能收藏")
    @GetMapping("/throwSkillCollect")
    public Result<List<ThrowSkill>> getThrowSkillCollect(@RequestParam String mapId, @RequestParam String agentId, @RequestParam String skillIndex, @RequestParam String side) {
        Map<String, Object> userInfo = ThreadLocalUtil.get();
        String username = (String) userInfo.get("username");
        List<ThrowSkill> throwSkill = skillTypeService.getThrowSkillCollect(mapId, agentId, skillIndex, side, username);
        return Result.success(throwSkill);
    }

    @Operation(summary = "抛掷技能数量")
    @GetMapping("/throwSKillCounts")
    public Result<Integer> getThrowSKillCount(@RequestParam String mapId, @RequestParam String agentId, @RequestParam String skillIndex) {
        int counts = skillTypeService.getThrowSkillCount(mapId, agentId, skillIndex);
        return Result.success(counts);
    }
    //#endregion

    //#region LineSKill
    @Operation(summary = "直线技能插入")
    @PostMapping("/lineSkill")
    public Result saveLineSkill(@RequestBody LineSkill lineSkill) {
        skillTypeService.saveLineSkill(lineSkill);
        return Result.success();
    }

    @Operation(summary = "直线技能查询")
    @GetMapping("/lineSkill")
    public Result<List<LineSkill>> getLineSkillList(@RequestParam String mapId, @RequestParam String agentId, @RequestParam int skillIndex, @RequestParam String side) {
        List<LineSkill> lineSkills = skillTypeService.getLineSkillList(mapId, agentId, skillIndex, side);
        return Result.success(lineSkills);
    }

    @Operation(summary = "直线技能收藏")
    @GetMapping("/lineSkillCollect")
    public Result<List<LineSkill>> getLineSkillListCollect(@RequestParam String mapId, @RequestParam String agentId, @RequestParam int skillIndex, @RequestParam String side) {
        Map<String, Object> userInfo = ThreadLocalUtil.get();
        String username = (String) userInfo.get("username");
        List<LineSkill> lineSkills = skillTypeService.getLineSkillCollect(mapId, agentId, skillIndex, side, username);
        return Result.success(lineSkills);
    }

    @Operation(summary = "直线技能数量")
    @GetMapping("/lineSkillCounts")
    public Result<Integer> getLineSkillCounts(@RequestParam String mapId, @RequestParam String agentId, @RequestParam int skillIndex) {
        int counts = skillTypeService.getLineSkillCount(mapId, agentId, skillIndex);
        return Result.success(counts);
    }
    //#endregion
}
