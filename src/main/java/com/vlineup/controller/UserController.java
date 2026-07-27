package com.vlineup.controller;

import com.vlineup.entity.User;
import com.vlineup.service.UserService;
import com.vlineup.utils.JWTUtil;
import com.vlineup.utils.Md5Util;
import com.vlineup.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Operation(summary = "注册接口")
    @PostMapping("/register")
    public Result register(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(Md5Util.getMD5String(password));
        user.setEmail(email);
        userService.saveUser(user);
        return Result.success();
    }

    @Operation(summary = "登录接口")
    @GetMapping("/login")
    public Result<String> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.getUserByName(username);
        if (user != null) {
            if (Md5Util.getMD5String(password).equals(user.getPassword())) {
                Map<String, Object> userInfo = new HashMap<>();
                userInfo.put("id", user.getId());
                userInfo.put("username", user.getUsername());
                String token = JWTUtil.genToken(userInfo);
                return Result.success(token);
            } else {
                return Result.error("密码错误");
            }
        } else {
            return Result.error("用户名不存在");
        }
    }

    @Operation(summary = "获取用户信息")
    @GetMapping("/info")
    public Result<User> getUserInfo(@RequestParam String username) {
        //Map<String,Object> userInfo= ThreadLocalUtil.get();
        //String name=(String) userInfo.get("username");
        User user = userService.getUserInfo(username);
        return Result.success(user);
    }

    @Operation(summary = "根据邮箱查询用户数量")
    @GetMapping("/count")
    //区分RequestBody注解的来源！！springframework
    public Result<Long> getUserCountByEmail(@RequestParam String email) {
        Long count = userService.getUserCountByEmail(email);
        return Result.success(count);
    }

    //@Operation(summary = "查询用户数量")
    //@PostMapping("/count")
    ////区分RequestBody注解的来源！！springframework
    //public Result<Long> getUserByUer(@RequestBody User user) {
    //    System.out.println(user);
    //    long count = 1;
    //    //Long count = userService.getUserCount(user);
    //    return Result.success(count);
    //}


}
