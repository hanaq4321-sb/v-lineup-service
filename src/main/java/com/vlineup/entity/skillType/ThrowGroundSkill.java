package com.vlineup.entity.skillType;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("throwground_skill")
public class ThrowGroundSkill {
    @TableId(value = "uuid", type = IdType.INPUT)
    private String uuid;
    private String agentId;
    private String mapId;
    private int skillIndex;
    private float groupX;
    private float groupY;
    private float angle;
}