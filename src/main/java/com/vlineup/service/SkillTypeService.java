package com.vlineup.service;

import com.vlineup.entity.skillType.ThrowSkill;

import java.util.List;

public interface SkillTypeService {
    //ThrowSkill
    void saveThrowSkill(ThrowSkill throwSkill);

    List<ThrowSkill> getThrowSkillList(String mapId, String AgentId, String skillIndex, String side);

    List<ThrowSkill> getThrowSkillCollect(String mapId, String agentId, String skillIndex, String side, String username);

    int getThrowSkillCount(String mapId, String agentId, String skillIndex);

}
