package com.vlineup.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.vlineup.entity.skillType.ControlSkill;
import com.vlineup.entity.skillType.LineSkill;
import com.vlineup.entity.skillType.ThrowSkill;
import com.vlineup.mapper.SkillTyperMapper;
import com.vlineup.service.SkillTypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillTypeServiceImpl implements SkillTypeService {

    @Resource
    private SkillTyperMapper skillTyperMapper;

    //#region ThrowSkill
    @Override
    public void saveThrowSkill(ThrowSkill throwSkill) {
        skillTyperMapper.insertThrowSkill(throwSkill);
    }

    @Override
    public List<ThrowSkill> getThrowSkillList(String mapId, String agentId, String skillIndex, String side) {
        return skillTyperMapper.selectThrowSkillList(mapId, agentId, skillIndex, side);
    }

    @Override
    public List<ThrowSkill> getThrowSkillCollect(String mapId, String agentId, String skillIndex, String side, String username) {
        return skillTyperMapper.selectThrowSkillCollect(mapId, agentId, skillIndex, side, username);
    }

    @Override
    public int getThrowSkillCount(String mapId, String agentId, String skillIndex) {
        return skillTyperMapper.selectCountThrowSKill(mapId, agentId, skillIndex);
    }
    //#endregion

    //#region ThrowGroundSkill
    @Override
    public void saveThrowGroundSkill(ThrowSkill throwSkill) {
        skillTyperMapper.insertThrowGroundSkill(throwSkill);
    }

    @Override
    public List<ThrowSkill> getThrowGroundSkillList(String mapId, String agentId, String skillIndex, String side) {
        return skillTyperMapper.selectThrowGroundSkillList(mapId, agentId, skillIndex, side);
    }

    @Override
    public List<ThrowSkill> getThrowGroundSkillCollect(String mapId, String agentId, String skillIndex, String side, String username) {
        return skillTyperMapper.selectThrowGroundSkillCollect(mapId, agentId, skillIndex, side, username);
    }

    @Override
    public int getThrowGroundSkillCount(String mapId, String agentId, String skillIndex) {
        return skillTyperMapper.selectCountThrowGroundSKill(mapId, agentId, skillIndex);
    }
    //#endregion ThrowGroundSkill

    //#region LineSkill
    @Override
    public void saveLineSkill(LineSkill lineSkill) {
        skillTyperMapper.insertLineSkill(lineSkill);
    }

    @Override
    public List<LineSkill> getLineSkillList(String mapId, String agentId, int skillIndex, String side) {
        return skillTyperMapper.selectLineSkillList(mapId, agentId, skillIndex, side);
    }

    @Override
    public List<LineSkill> getLineSkillCollect(String mapId, String agentId, int skillIndex, String side, String username) {
        return skillTyperMapper.selectLineSkillCollect(mapId, agentId, skillIndex, side, username);
    }

    @Override
    public int getLineSkillCount(String mapId, String agentId, int skillIndex) {
        return skillTyperMapper.selectCountLineSkill(mapId, agentId, skillIndex);
    }
    //#endregion

    //#region ControlSkill
    @Override
    public void saveControlSkill(ControlSkill controlSkill) {
        skillTyperMapper.insertControlSkill(controlSkill);
    }

    @Override
    public List<ControlSkill> getControlSkillList(String mapId, String agentId, int skillIndex, String side) {
        return skillTyperMapper.selectControlSkillList(mapId, agentId, skillIndex, side);
    }

    @Override
    public List<ControlSkill> getControlSkillCollect(String mapId, String agentId, int skillIndex, String side, String username) {
        return skillTyperMapper.selectControlSkillCollect(mapId, agentId, skillIndex, side, username);
    }

    @Override
    public int getControlSkillCount(String mapId, String agentId, int skillIndex) {
        return skillTyperMapper.selectCountControlSkill(mapId, agentId, skillIndex);
    }
    //#endregion
}
