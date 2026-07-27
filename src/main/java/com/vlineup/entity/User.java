package com.vlineup.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//用户Id，自增
    private String username;//用户名，不能重复
    private String password;//密码，MD5
    private String email;//邮箱
    private String avatar;//头像地址
    private Integer points;//积分
    private Integer upload;//上传数量
    private Integer role;//角色，0-用户，1-管理员
}
