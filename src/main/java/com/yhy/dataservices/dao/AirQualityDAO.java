package com.yhy.dataservices.dao;

import com.yhy.dataservices.entity.AirQuality;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirQualityDAO {

    /**
     * 获取空气质量数据的列表
     * @return
     */
    List<AirQuality> getAirQualityList(@Param("cityName")String cityName) ;

    /**
     * 删除一条空气质量数据
     * @param id
     * @return
     */
    Boolean deleteAirQuality(Integer id);

    /**
     * 新增一条空气质量数据
     * @param airQuality
     * @return
     */
    Boolean addAirQuality(AirQuality airQuality);

}
