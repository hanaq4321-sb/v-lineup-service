package com.vlineup.mapper;

import com.vlineup.entity.skillType.LineSkill;
import com.vlineup.entity.skillType.ThrowSkill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SkillTyperMapper {
    // Throw
    void insertThrowSkill(ThrowSkill throwSkill);

    List<ThrowSkill> selectThrowSkillList(String mapId, String agentId, String skillIndex, String side);

    List<ThrowSkill> selectThrowSkillCollect(String mapId, String agentId, String skillIndex, String side, String username);

    @Select("SELECT count(*) from throw_skill where map_id=#{mapId} and skill_index =#{skillIndex} and agent_id=#{agentId}")
    int selectCountThrowSKill(String mapId, String agentId, String skillIndex);

    // Line
    void insertLineSkill(LineSkill lineSkill);

    List<LineSkill> selectLineSkillList(String mapId, String agentId, int skillIndex, String side);

    List<LineSkill> selectLineSkillCollect(String mapId, String agentId, int skillIndex, String side, String username);

    @Select("select count(*) from line_skill where map_id=#{mapId} and agent_id=#{agentId} and skill_index=#{skillIndex}")
    int selectCountLineSkill(String mapId, String agentId, int skillIndex);

}
