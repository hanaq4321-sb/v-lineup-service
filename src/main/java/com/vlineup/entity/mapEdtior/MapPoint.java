package com.vlineup.entity.mapEdtior;

import lombok.Data;

@Data
public class MapPoint {
    private String uuid;
    private String mapId;
    private String text;
    private float x;
    private float y;
}
