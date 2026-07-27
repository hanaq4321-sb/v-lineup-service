package com.vlineup.entity.mapEdtior;

import lombok.Data;

@Data
public class MapBarrier {
    private String uuid;
    private String mapId;
    private float x;
    private float y;
    private float rotation;
    private float scaleX;
    private Integer side;
}
