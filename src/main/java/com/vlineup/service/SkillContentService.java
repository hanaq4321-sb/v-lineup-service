package com.vlineup.service;

import com.vlineup.entity.SkillContent;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SkillContentService {
    SkillContent getSkillContentByUUID(String uuid);

    void saveSkillContent(SkillContent skillContent);

    void updateSkillContent(String videoName, String uuid);


}
