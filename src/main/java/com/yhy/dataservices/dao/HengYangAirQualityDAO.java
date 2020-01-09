package com.yhy.dataservices.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HengYangAirQualityDAO {
    /**
     * 2018年表中的aqi数据
     * @param cityName
     * @return
     */
    List<Integer> getAqi2018(String cityName);

    /**
     * 获取空气质量为优
     * @return
     */
    Integer getAirQualitySuperior(String cityName);

    /**
     * 获取空气质量为良
     * @param cityName
     * @return
     */
    Integer getAirQualityFine(String cityName);

    /**
     * 获取空气质量为轻度污染
     * @param cityName
     * @return
     */
    Integer getAirQualityMild(String cityName);

    /**
     * 获取空气质量为中度污染
     * @param cityName
     * @return
     */
    Integer getAirQualityMiddle(String cityName);
}
