package com.vlineup.controller;

import com.vlineup.service.CollectAndLikeService;
import com.vlineup.utils.JWTUtil;
import com.vlineup.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "收藏和点赞")
@RestController
@RequestMapping("/collect_like")
public class CollectAndLikeController {

    @Resource
    private CollectAndLikeService collectAndLikeService;

    @Operation(summary = "查询是否已收藏")
    @GetMapping("/collect")
    public Result<Boolean> ifCollect(@RequestParam String token, @RequestParam String uuid) {
        Map<String, Object> claims = JWTUtil.parseToken(token);
        String username = (String) claims.get("username");
        Boolean bool = collectAndLikeService.isAlreadyCollect(username, uuid);
        return Result.success(bool);
    }

    @Operation(summary = "新增收藏")
    @PostMapping("/collect")
    public Result saveCollect(@RequestParam String token, @RequestParam String uuid) {
        Map<String, Object> claims = JWTUtil.parseToken(token);
        String username = (String) claims.get("username");
        collectAndLikeService.saveCollect(username, uuid);
        return Result.success();
    }

    @Operation(summary = "删除收藏")
    @DeleteMapping("/collect")
    public Result removeCollect(@RequestParam String token, @RequestParam String uuid) {
        Map<String, Object> claims = JWTUtil.parseToken(token);
        String username = (String) claims.get("username");
        collectAndLikeService.removeCollect(username, uuid);
        return Result.success();
    }
}
