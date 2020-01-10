package com.yhy.dataservices.service;

import com.yhy.dataservices.dto.cityAirQuality.EchartsDTO;

import java.util.List;
import java.util.Map;

public interface HengYangAirQualityService {

    /**
     * 2018-2019 衡阳市aqi数据
     * @return
     */
      Map<String,Object> getAqiByHengYang();

    /**
     * 2018年 衡阳市空气质量
      * @return
     */
      List<EchartsDTO> getAirQualityFrom2018();

    /**
     * 2019年 衡阳市空气质量
     * @return
     */
    List<EchartsDTO> getAirQualityFrom2019();

    /**
     *2019年衡阳市AQI，PM2.5,PM10走势图
     */
    Map<String,Object>  getAirQualityByHengYang();

    /**
     * 2018年衡阳市AQI与PM2.5关系图
     * @return
     */
    Map<String,Object> getPm10AndPm25From2018();
}
