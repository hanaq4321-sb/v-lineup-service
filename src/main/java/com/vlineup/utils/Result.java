package com.vlineup.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;//状态码，0-成功，1-失败
    private String msg;//提示信息
    private T data;//常规方法可以使用类的泛型参数

    //返回操作响应成功结果（带响应数据）
    //静态方法因为不需要声明className.fc，故不能使用类属性，必须自己声明独立的泛型参数， 静态方法使用自己的泛型参数
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    //成功结果，不带响应数据
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    public static Result error(String msg) {
        return new Result(1, msg, null);
    }

}
