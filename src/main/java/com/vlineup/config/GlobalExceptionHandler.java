package com.vlineup.config;

import com.vlineup.utils.Result;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//ControllerAdvice和swagger冲突
@Hidden
//修改RestController注解下的异常处理机制
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");//如果有异常原因就返回，否则只返回操作失败
    }
}
