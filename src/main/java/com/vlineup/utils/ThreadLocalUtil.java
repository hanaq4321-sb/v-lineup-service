package com.vlineup.utils;

public class ThreadLocalUtil {
    //提供ThreadLocal全局对象
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    //获取存在线程中的值
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    public static void set(Object value) {
        THREAD_LOCAL.set(value);
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
