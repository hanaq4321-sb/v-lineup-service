package com.vlineup.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vlineup.entity.User;
import com.vlineup.mapper.UserMapper;
import com.vlineup.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * mybatis-plus封装CRUD
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserByName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("username", username);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public User getUserInfo(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .select(User::getUsername, User::getEmail, User::getAvatar, User::getPoints)
                .eq(User::getUsername, username);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public Long getUserCountByEmail(String email) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getEmail, email);
        return userMapper.selectCount(wrapper);
    }

    @Override
    public Long getUserCount(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, user.getUsername())
                .or()
                .eq(User::getEmail, user.getEmail());
        return userMapper.selectCount(wrapper);
    }


}
