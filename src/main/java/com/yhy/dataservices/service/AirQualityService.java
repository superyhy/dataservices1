package com.yhy.dataservices.service;


import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.entity.AirQuality;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    /**
     * 根据ID获取空气质量数据
     * @param id
     * @return
     */
    AirQuality getAirQualityById(Integer id);

    /**
     * 修改一条空气质量数据
     * @param airQuality
     * @return
     */
    Boolean updateAirQuality(AirQuality airQuality);

    /**
     * 下载一条空气质量数据
     * @param id
     * @return
     */
    Boolean downloadAirQuality(HttpServletResponse response,Integer id);
}