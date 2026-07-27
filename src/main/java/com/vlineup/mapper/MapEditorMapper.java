package com.vlineup.mapper;

import com.vlineup.entity.mapEdtior.MapBarrier;
import com.vlineup.entity.mapEdtior.MapPoint;
import com.vlineup.entity.mapEdtior.MapSkillBall;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapEditorMapper {
    void insertOrUpdateMapBarrier(List<MapBarrier> mapBarrier);

    List<MapBarrier> selectMapBarrierList(String mapId);

    void insertOrUpdateMapPoint(List<MapPoint> mapPoint);

    List<MapPoint> selectMapPointList(String mapId);

    void insertOrUpdateMapSkillBall(List<MapSkillBall> mapSkillBall);

    List<MapSkillBall> selectMapSkillBallList(String mapId);

    void deleteMapNode(String uuid, String tableName);
}
