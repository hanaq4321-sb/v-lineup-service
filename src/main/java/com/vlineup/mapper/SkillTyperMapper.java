package com.vlineup.mapper;

import com.vlineup.entity.skillType.ThrowSkill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SkillTyperMapper {
    // Thorw
    void insertThrowSkill(ThrowSkill throwSkill);

    List<ThrowSkill> selectThrowSkillList(String mapId, String agentId, String skillIndex, String side);

    List<ThrowSkill> selectThrowSkillCollect(String mapId, String agentId, String skillIndex, String side, String username);

    @Select("SELECT count(*) from throw_skill where map_id=#{mapId} and skill_index =#{skillIndex} and agent_id=#{agentId}")
    int selectCountThrowSKill(String mapId, String agentId, String skillIndex);
}
