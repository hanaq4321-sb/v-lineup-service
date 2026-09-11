package com.vlineup.entity.skillType;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "control_skill", autoResultMap = true)
public class ControlSkill {
    @TableId(value = "uuid", type = IdType.INPUT)
    private String uuid;
    private String agentId;
    private String mapId;
    private int skillIndex;
    private float skillIconX;
    private float skillIconY;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Integer> pointList;
}
/*
 * 1、List结合配合typeHandler+autoResultMap的使用可以自动转化为json数据存入到mysql的json格式中，
 *    一般数组可以直接使用，若需要带有键值对的对象类型，则需要另外声明一个实体类，作为类型参数传入List中。
 * 2、指定TypeHandler后，使用mysql-plus提供的方法可以正常生效。若使用注解或者mapper.xml文件则需要在
 *    相应位置额外指明typeHandler，占位符参数可直接在后面声明，select查询则需要再resultMap中声明。
 * 3、
 * */

