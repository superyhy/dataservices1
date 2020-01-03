package com.yhy.dataservices.dao;

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


}
