package com.yhy.dataservices.service.Impl;

import com.yhy.dataservices.dao.HengYangAirQualityDAO;
import com.yhy.dataservices.dao.CityAirQualityDAO;
import com.yhy.dataservices.dto.cityAirQuality.EchartsDTO;
import com.yhy.dataservices.entity.CityAirQuality;
import com.yhy.dataservices.service.HengYangAirQualityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class HengYangAirQualityServiceImpl implements HengYangAirQualityService {

    @Autowired
    HengYangAirQualityDAO cityAirQuality2018DAO;

    @Autowired
    CityAirQualityDAO cityAirQualityDAO;

    @Override
    public Map<String,Object> getAqiByHengYang() {

        Map<String,Object> resultMap=new HashMap<>();
        //2019年衡阳市aqi数据
        List<String> cityNames=new ArrayList<>();
        cityNames.add("衡阳");
        List<CityAirQuality> targetList;
        try{
            targetList=cityAirQualityDAO.getCityAirQualityByCityName(cityNames);
        } catch (Exception e) {
            log.error("{} 获取2019年aqi数据失败",getClass(),e);
            throw e;
        }

        List<Integer> aqiListFrom2019=targetList.stream().map(i->i.getAqi()).collect(Collectors.toList());

        //2018年衡阳市aqi数据
        List<Integer> aqiListFrom2018;
        try{
             aqiListFrom2018=cityAirQuality2018DAO.getAqi2018("衡阳");
        } catch (Exception e) {
            log.error("{} 获取2018年aqi数据失败",getClass(),e);
            throw e;
        }

        //返回结果
        resultMap.put("aqiListFrom2019",aqiListFrom2019);
        resultMap.put("aqiListFrom2018",aqiListFrom2018);

        return resultMap;

    }

    @Override
    public List<EchartsDTO> getAirQualityFrom2018() {
        String cityName="衡阳";
        List<EchartsDTO> resultList=new ArrayList<>();
        resultList.add(new EchartsDTO("优",cityAirQuality2018DAO.getAirQualitySuperior(cityName)));
        resultList.add(new EchartsDTO("良",cityAirQuality2018DAO.getAirQualityFine(cityName)));
        resultList.add(new EchartsDTO("轻度污染",cityAirQuality2018DAO.getAirQualityMild(cityName)));
        resultList.add(new EchartsDTO("中度污染",cityAirQuality2018DAO.getAirQualityMiddle(cityName)));
        return resultList;
    }

    @Override
    public List<EchartsDTO> getAirQualityFrom2019() {
        String cityName="衡阳";
        List<EchartsDTO> resultList=new ArrayList<>();
        resultList.add(new EchartsDTO("优",cityAirQualityDAO.getAirQualitySuperior(cityName)));
        resultList.add(new EchartsDTO("良",cityAirQualityDAO.getAirQualityFine(cityName)));
        resultList.add(new EchartsDTO("轻度污染",cityAirQualityDAO.getAirQualityMild(cityName)));
        resultList.add(new EchartsDTO("中度污染",cityAirQualityDAO.getAirQualityMiddle(cityName)));
        return resultList;
    }
}
