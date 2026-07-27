package com.vlineup.service;

import com.vlineup.entity.mapEdtior.MapBarrier;
import com.vlineup.entity.mapEdtior.MapPoint;
import com.vlineup.entity.mapEdtior.MapSkillBall;

import java.util.List;

public interface MapEditorService {
    void saveOrUpdateMapBarrier(List<MapBarrier> mapBarrier);

    List<MapBarrier> getMapBarrierList(String mapId);

    void saveOrUpdateMapPoint(List<MapPoint> mapPoint);

    List<MapPoint> getMapPointList(String mapId);

    void saveOrUpdateMapSkillBall(List<MapSkillBall> mapSkillBall);

    List<MapSkillBall> getMapSkillBallList(String mapId);

    void removeMapNode(String uuid, String tableName);
}
