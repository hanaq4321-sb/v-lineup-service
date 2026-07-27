package com.vlineup.interceptor;

import com.vlineup.utils.JWTUtil;
import com.vlineup.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * 同一个ThreadLocal变量在不同线程下存储不同的值，线程安全
 * 每当有一个用户请求时，服务器就会分配一个线程，每个线程之间相互隔离。TL就可以在不同线程之间存储不同值
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {
    //请求前的处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从前端请求中头中获取token
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JWTUtil.parseToken(token);
            //根据token获取存储在对应JWT中的claims，存有用户ID和username
            ThreadLocalUtil.set(claims);
            return true;
        } catch (Exception e) {
            //token解析失败会抛出异常，则证明token有误
            response.setStatus(401);
            return false;
        }
    }

    //请求完成后的处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
