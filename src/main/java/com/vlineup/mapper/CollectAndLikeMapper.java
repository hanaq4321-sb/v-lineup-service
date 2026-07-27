package com.vlineup.mapper;

import com.vlineup.entity.UserCollect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CollectAndLikeMapper {
    @Select("select * from skill_collect where username=#{username} and skill_uuid=#{uuid} limit 1")
    UserCollect isAlreadyCollect(String username, String uuid);

    @Insert("insert into skill_collect (username,skill_uuid) values (#{username},#{uuid})")
    void insertCollect(String username, String uuid);

    @Delete("delete from skill_collect where username=#{username} and skill_uuid=#{uuid}")
    void deleteCollect(String username, String uuid);
}
