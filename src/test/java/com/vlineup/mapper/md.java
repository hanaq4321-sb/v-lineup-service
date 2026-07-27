package com.vlineup.mapper;

import com.vlineup.utils.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class md {

    @Value("${qiniu.kodo.accessKey}")
    private static String accessKey;
    //static 修饰无法获取

    @Test
    public void testMD5() {
        String p = "123456";
        System.out.println(Md5Util.getMD5String(p));
    }

    @Test
    public void time() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-mm-dd_HH:mm:ss");
        String a = LocalDateTime.now().format(pattern);
        System.out.println(a);
    }

}
