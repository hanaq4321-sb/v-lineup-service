package com.vlineup.controller;

import com.vlineup.entity.SkillData;
import com.vlineup.service.SkillDataService;
import com.vlineup.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "技能数据")
@RestController
@RequestMapping("/skillData")
public class SkillDataController {
    @Resource
    private SkillDataService skillDataService;

    @Operation(summary = "获取所有技能数据")
    @GetMapping
    public Result<List<SkillData>> skillDataList() {
        List<SkillData> skillDataList = skillDataService.skillDataList();
        return Result.success(skillDataList);
    }
    
}
