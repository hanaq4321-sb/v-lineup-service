package com.vlineup.entity.skillType;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("throw_skill")
public class ThrowSkill {
    @TableId(value = "uuid", type = IdType.INPUT)
    private String uuid;
    private String agentId;
    private String mapId;
    private float skillIndex;
    private float skillIconX;
    private float skillIconY;
    private float agentIconX;
    private float agentIconY;
}
