package com.vlineup.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.vlineup.entity.UserCollect;
import com.vlineup.mapper.CollectAndLikeMapper;
import com.vlineup.service.CollectAndLikeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CollectAndLikeServiceImpl implements CollectAndLikeService {
    @Resource
    private CollectAndLikeMapper collectAndLikeMapper;

    @Override
    public Boolean isAlreadyCollect(String username, String uuid) {
        Boolean result = false;
        UserCollect userCollect = collectAndLikeMapper.isAlreadyCollect(username, uuid);
        if (userCollect != null) {
            result = true;
        }
        return result;
    }

    @Override
    public void saveCollect(String username, String uuid) {
        collectAndLikeMapper.insertCollect(username, uuid);
    }

    @Override
    public void removeCollect(String username, String uuid) {
        collectAndLikeMapper.deleteCollect(username, uuid);
    }
}
