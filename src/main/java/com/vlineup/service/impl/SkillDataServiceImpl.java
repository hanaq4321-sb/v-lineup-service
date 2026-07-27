package com.vlineup.service.impl;

import com.vlineup.entity.SkillData;
import com.vlineup.mapper.SkillDataMapper;
import com.vlineup.service.SkillDataService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillDataServiceImpl implements SkillDataService {
    @Resource
    private SkillDataMapper skillDataMapper;

    @Override
    public List<SkillData> skillDataList() {
        return skillDataMapper.selectSkillDataList();
    }


}
