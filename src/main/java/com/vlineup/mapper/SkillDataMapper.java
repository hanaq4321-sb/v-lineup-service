package com.vlineup.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vlineup.entity.SkillData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SkillDataMapper extends BaseMapper<SkillData> {

    @Select("select * from skill_data")
    List<SkillData> selectSkillDataList();

}
