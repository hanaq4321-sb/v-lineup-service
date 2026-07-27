package com.vlineup.controller;

import com.vlineup.entity.SkillContent;
import com.vlineup.service.SkillContentService;
import com.vlineup.utils.QiniuKodoUtil;
import com.vlineup.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "技能内容")
@RestController
@RequestMapping("/skillContent")
public class SkillContentController {

    @Resource
    private SkillContentService skillContentService;

    @Operation(summary = "获取技能内容")
    @GetMapping
    public Result<SkillContent> getSkillContent(@RequestParam String uuid) {
        SkillContent skillContent = skillContentService.getSkillContentByUUID(uuid);
        return Result.success(skillContent);
    }

    @Operation(summary = "新增技能内容")
    @PostMapping
    public Result saveSkillContent(@RequestPart("skillContent") SkillContent skillContent, @RequestPart("file") MultipartFile[] multipartFile, @RequestPart(value = "video", required = false) MultipartFile videoFile) throws IOException {
        List<PictureJson> pictureJsonList = skillContent.getPicture();
        for (int index = 0; index < multipartFile.length; index++) {
            String fileName = QiniuKodoUtil.upload(multipartFile[index]);
            pictureJsonList.get(index).setUrl(fileName);
        }
        String videoName = null;
        if (videoFile != null) {
            videoName = QiniuKodoUtil.upload(videoFile);
        }
        skillContent.setVideo(videoName);
        skillContent.setPicture(pictureJsonList);
        skillContentService.saveSkillContent(skillContent);
        return Result.success();
    }

    @Operation(summary = "修改视频内容")
    @PostMapping("/video")
    public Result updateSkillContentVideo(@RequestPart(value = "video") MultipartFile videoFile, @RequestParam String uuid) throws IOException {
        String videoName = QiniuKodoUtil.upload(videoFile);
        skillContentService.updateSkillContent(videoName, uuid);
        return Result.success();
    }


}
