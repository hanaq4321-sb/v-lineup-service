package com.vlineup.mapper;

import com.vlineup.entity.User;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
//@MapperScan(basePackages = "com.vlineup.mapper")
public class insertSkillDataTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test() {
        User users = userMapper.selectById(1);
        System.out.println(users);
    }

}
