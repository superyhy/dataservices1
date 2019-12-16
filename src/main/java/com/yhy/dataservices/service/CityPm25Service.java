package com.yhy.dataservices.service;

import com.yhy.dataservices.entity.CityPm25;

import java.util.List;
import java.util.Map;

public interface CityPm25Service {

    /**
     * 获取城市的pm2.5值
     * @return
     */
    Map<String,Object> getCityPm25List();
}
