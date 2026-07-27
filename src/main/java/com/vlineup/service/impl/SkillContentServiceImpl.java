package com.vlineup.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.vlineup.entity.SkillContent;
import com.vlineup.mapper.SkillContentMapper;
import com.vlineup.service.SkillContentService;
import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;


@Service
public class SkillContentServiceImpl implements SkillContentService {

    @Resource
    SkillContentMapper skillContentMapper;

    @Override
    public SkillContent getSkillContentByUUID(String uuid) {
        LambdaQueryWrapper<SkillContent> wrapper = new LambdaQueryWrapper<SkillContent>()
                .eq(SkillContent::getUuid, uuid);
        SkillContent skillContent = skillContentMapper.selectOne(wrapper);
        return skillContent;
    }

    @Override
    public void saveSkillContent(SkillContent skillContent) {
        skillContent.setUpdateTime(LocalDateTime.now());
        skillContentMapper.insert(skillContent);
    }

    @Override
    public void updateSkillContent(String videoName, String uuid) {
        LambdaUpdateWrapper<SkillContent> wrapper = new LambdaUpdateWrapper<SkillContent>()
                .eq(SkillContent::getUuid, uuid)
                .set(SkillContent::getVideo, videoName);
        skillContentMapper.update(wrapper);
    }


}
