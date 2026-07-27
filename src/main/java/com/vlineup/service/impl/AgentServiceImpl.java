package com.vlineup.service.impl;

import com.vlineup.entity.Agent;
import com.vlineup.mapper.AgentMapper;
import com.vlineup.service.AgentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {
    @Resource
    private AgentMapper agentMapper;

    @Override
    public List<Agent> getAgentList() {
        return agentMapper.selectList(null);
    }
}
