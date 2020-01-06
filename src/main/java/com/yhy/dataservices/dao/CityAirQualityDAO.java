package com.yhy.dataservices.dao;

import com.yhy.dataservices.dto.cityAirQuality.AqiAvgDTO;
import com.yhy.dataservices.dto.cityAirQuality.Pm25AvgDTO;
import com.yhy.dataservices.entity.CityAirQuality;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityAirQualityDAO {

    /**
     * 用于获取长沙，株洲两市的空气质量数据
     * @param cityNames
     * @return
     */
    List<CityAirQuality> getCityAirQualityByCityName(@Param("cityNames") List<String> cityNames);

    /**
     * 2019年城市AQI平均值
     * @return
     */
    List<AqiAvgDTO> getCityAqiAvg();

    /**
     * 2019年城市pm2.5平均值
     * @return
     */
    List<Pm25AvgDTO> getCityPm25Avg();

}
