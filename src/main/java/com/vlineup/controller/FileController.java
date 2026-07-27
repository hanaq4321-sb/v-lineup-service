package com.vlineup.controller;

import com.vlineup.utils.QiniuKodoUtil;
import com.vlineup.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Tag(name = "文件上传")
@RestController
@RequestMapping("/file")
public class FileController {

    @Operation(summary = "文件上传")
    @PostMapping
    public Result<String> upload(@RequestPart("file") MultipartFile multipartFile) throws IOException {
        System.out.println(QiniuKodoUtil.upload(multipartFile));
        return Result.success();
    }

    @Operation(summary = "文件删除")
    @DeleteMapping
    public Result<String> upload(@RequestParam String fileKey) throws IOException {
        QiniuKodoUtil.delete(fileKey);
        return Result.success();
    }
}
