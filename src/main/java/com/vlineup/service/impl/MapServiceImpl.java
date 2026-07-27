package com.vlineup.service.impl;

import com.vlineup.entity.Map_;
import com.vlineup.mapper.MapMapper;
import com.vlineup.service.MapService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapServiceImpl implements MapService {

    @Resource
    private MapMapper mapMapper;

    @Override
    public List<Map_> getMapList() {
        return mapMapper.selectList(null);
    }
}
