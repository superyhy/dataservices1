package com.yhy.dataservices.service;

import java.util.List;
import java.util.Map;

public interface CityAirQualityService {

    /**
     * 获取长沙，株洲的AQI数据，用于 echarts4
     * @param
     * @return
     */
    Map<String,Object> getCityAqi();

    /**
     * 2019年各市的aqi平均值
     * @return
     */
    Map<String,Object> getAqiAvg();

    /**
     * 2019年各市的pm2.5平均值
     * @return
     */
    Map<String,Object> getPm25Avg();

}
