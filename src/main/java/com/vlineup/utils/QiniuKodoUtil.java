package com.vlineup.utils;


import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.*;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Component
public class QiniuKodoUtil {

    private static String accessKey = "NxiN4TDmo6XRGtLl2JelpSyTWYn7aIznfHpZt_VL";
    private static String secretKey = "6NocNoNQKyYr5HiAeC0Nk1CGOcg6PVHLNdpDnahe";
    private static String bucket = "v-lineup";
    private static String domain = "v-lineup.top";
    private static String path = "v-lineup/";

    public static String upload(MultipartFile file) throws IOException {
        // 创建上传token
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        // 设置上传配置，Region要与存储空间所属的存储区域保持一致
        Region region = Region.huadong();
        Configuration cfg = Configuration.create(region);

        // 创建上传管理器
        UploadManager uploadManager = new UploadManager(cfg);

        String originalFilename = file.getOriginalFilename();
        // 构造文件目录和文件名
        assert originalFilename != null;
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-mm-dd_HH:mm:ss");
        String time = LocalDateTime.now().format(pattern);
        String fileKey = path + time + UUID.randomUUID() + suffix;

        // 上传文件
        Response response = uploadManager.put(file.getInputStream(), fileKey, upToken, null, null);

        // 返回文件url
        return "https://" + domain + "/" + fileKey;
    }

    public static void delete(String fileKey) throws QiniuException {
        Auth auth = Auth.create(accessKey, secretKey);

        Configuration cfg = Configuration.create(Region.huadong());
        BucketManager bucketManager = new BucketManager(auth, cfg);

        bucketManager.delete(bucket, fileKey);
    }

}

