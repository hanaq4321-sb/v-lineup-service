package com.vlineup.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.vlineup.entity.SkillContent;
import com.vlineup.entity.User;

public interface UserService {
    void saveUser(User user);

    User getUserByName(String username);

    User getUserInfo(String username);

    Long getUserCount(User user);

    Long getUserCountByEmail(String email);


}
