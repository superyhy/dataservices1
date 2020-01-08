package com.yhy.dataservices.service;

import com.yhy.dataservices.dto.cityAirQuality.EchartsDTO;
import com.yhy.dataservices.dto.cityAirQuality.Pm10AvgDTO;

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

    /**
     * 长沙市饼图
     * @param
     * @return
     */
    List<EchartsDTO> getChangshaAirQuality();

    /**
     * 岳阳市饼图
     * @return
     */
    List<EchartsDTO> getYueYangAirQuality();

    /**
     * 郴州市饼图
     * @return
     */
    List<EchartsDTO> getChenZhouAirQuality();

    /**
     * 用于获取衡阳，岳阳，郴州三市的Pm2.5数据
     * @return
     */
    Map<String,Object> getCityPM25();

    /**
     * 2019年各市pm10平均值
     * @return
     */
    List<Pm10AvgDTO> getPm10Avg();

}
