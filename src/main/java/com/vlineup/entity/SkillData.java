package com.vlineup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillData {
    private String skillName;//技能中文名
    private String agentId;//特工英文名-外键
    private Integer skillIndex;//技能顺序
    private Integer width;//宽度，横的
    private Integer height;//高度，竖的
    private Integer r;//半径
    private Integer angle;//角度
    private Integer min;//最小尺寸
    private Integer max;//最大尺寸
    private String skillType;//技能类型
    private String skillType2;//放置技能类型
}
