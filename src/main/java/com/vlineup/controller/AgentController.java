package com.vlineup.controller;

import com.vlineup.entity.Agent;
import com.vlineup.service.AgentService;
import com.vlineup.utils.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "特工")
@RestController
@RequestMapping("/agent")
public class AgentController {

    @Resource
    private AgentService agentService;

    @GetMapping
    public Result<List<Agent>> getAgentList() {
        return Result.success(agentService.getAgentList());
    }

}
