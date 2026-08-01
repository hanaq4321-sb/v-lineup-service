package com.vlineup.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.vlineup.controller.PictureJson;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@TableName(value = "skill_content", autoResultMap = true)
public class SkillContent {
    @TableId(value = "uuid", type = IdType.INPUT)
    private String uuid;
    private String skillName;
    private String title;
    private String description;
    private String tolerance;
    private String posture;
    private String extra;
    private String side;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<PictureJson> picture;
    private String video;
    @TableField("`like`")
    private Integer like;
    private Integer collect;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}

