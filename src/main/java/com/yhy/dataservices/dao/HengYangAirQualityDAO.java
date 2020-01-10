package com.yhy.dataservices.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HengYangAirQualityDAO {
    /**
     * 2018年 表中的aqi数据
     * @param cityName
     * @return
     */
    List<Integer> getAqi2018(String cityName);

    /**
     * 2018年 表中pm2.5数据
     * @param cityName
     * @return
     */
    List<Integer> getPm25From2018(String cityName);

    /**
     * 2018 获取空气质量为优
     * @return
     */
    Integer getAirQualitySuperior(String cityName);

    /**
     * 2018获取空气质量为良
     * @param cityName
     * @return
     */
    Integer getAirQualityFine(String cityName);

    /**
     * 2018 获取空气质量为轻度污染
     * @param cityName
     * @return
     */
    Integer getAirQualityMild(String cityName);

    /**
     * 2018 获取空气质量为中度污染
     * @param cityName
     * @return
     */
    Integer getAirQualityMiddle(String cityName);
}
