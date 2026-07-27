package com.vlineup.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("map")
public class Map_ {
    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    private String mapName;
}
