package com.vlineup.service.impl;

import com.vlineup.entity.mapEdtior.MapBarrier;
import com.vlineup.entity.mapEdtior.MapPoint;
import com.vlineup.entity.mapEdtior.MapSkillBall;
import com.vlineup.mapper.MapEditorMapper;
import com.vlineup.service.MapEditorService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapEditorImpl implements MapEditorService {

    @Resource
    private MapEditorMapper mapEditorMapper;

    @Override
    public void saveOrUpdateMapBarrier(List<MapBarrier> mapBarrier) {
        mapEditorMapper.insertOrUpdateMapBarrier(mapBarrier);
    }

    @Override
    public List<MapBarrier> getMapBarrierList(String mapId) {
        return mapEditorMapper.selectMapBarrierList(mapId);
    }

    @Override
    public void saveOrUpdateMapPoint(List<MapPoint> mapPoint) {
        mapEditorMapper.insertOrUpdateMapPoint(mapPoint);
    }

    @Override
    public List<MapPoint> getMapPointList(String mapId) {
        return mapEditorMapper.selectMapPointList(mapId);
    }

    @Override
    public void saveOrUpdateMapSkillBall(List<MapSkillBall> mapSkillBall) {
        mapEditorMapper.insertOrUpdateMapSkillBall(mapSkillBall);
    }

    @Override
    public List<MapSkillBall> getMapSkillBallList(String mapId) {
        return mapEditorMapper.selectMapSkillBallList(mapId);
    }

    @Override
    public void removeMapNode(String uuid, String tableName) {
        mapEditorMapper.deleteMapNode(uuid, tableName);
    }


}
