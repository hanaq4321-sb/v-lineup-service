package com.vlineup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@MapperScan("com.vlineup.mapper")
@SpringBootApplication
public class VLineupServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VLineupServiceApplication.class, args);
    }

}
