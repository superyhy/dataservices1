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
}
