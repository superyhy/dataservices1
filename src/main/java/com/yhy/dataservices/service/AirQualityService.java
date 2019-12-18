package com.yhy.dataservices.service;


import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.entity.AirQuality;

import java.util.Map;

public interface AirQualityService {

    /**
     * 分页查询空气质量数据
     * @param pageSize
     * @param pageIndex
     * @param cityName
     * @return
     */
    PageInfo<AirQuality> queryAirQuality(Integer pageSize, Integer pageIndex, String cityName);

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