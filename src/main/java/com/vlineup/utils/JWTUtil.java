package com.vlineup.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JWTUtil {

    private static final String KEY = "takamiyamio";

    //接收业务数据，生成token并返回
    public static String genToken(Map<String, Object> user) {
        return JWT.create()
                .withClaim("user", user)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2))
                .sign(Algorithm.HMAC256(KEY));
    }

    //接收token，验证token，并返回之前存入的数据
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("user")
                .asMap();
    }
}

