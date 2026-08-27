package com.vlineup.config;

import com.vlineup.interceptor.LoginInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;

    // 拦截器注册
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 收藏等等触发拦截器检测
        registry.addInterceptor(loginInterceptor).addPathPatterns("/user/register", "/throwSkillCollect", "/lineSkillCollect", "/throwGroundSkillCollect", "/controlSkillCollect");
    }
}
