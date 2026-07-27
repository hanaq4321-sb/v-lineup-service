package com.vlineup.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("skill_collect")
public class UserCollect {
    @TableId(value = "id", type = IdType.INPUT)
    private String username;
    private String skill_uuid;
}

