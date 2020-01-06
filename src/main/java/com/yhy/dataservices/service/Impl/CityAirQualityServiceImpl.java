package com.yhy.dataservices.service.Impl;

import com.yhy.dataservices.dao.CityAirQualityDAO;
import com.yhy.dataservices.dto.cityAirQuality.AqiAvgDTO;
import com.yhy.dataservices.dto.cityAirQuality.Pm25AvgDTO;
import com.yhy.dataservices.entity.CityAirQuality;
import com.yhy.dataservices.service.CityAirQualityService;
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
public class CityAirQualityServiceImpl implements CityAirQualityService {

    @Autowired
    CityAirQualityDAO cityAirQualityDAO;

    @Override
    public Map<String, Object> getCityAqi() {
         //设定城市名
         List<String> cityNames = new ArrayList<>();
         cityNames.add("长沙");
         cityNames.add("株洲");

         Map<String,Object> resultMap=new HashMap<>();

         List<CityAirQuality> targetList=new ArrayList<>();
         try{
             targetList=cityAirQualityDAO.getCityAirQualityByCityName(cityNames);
         } catch (Exception e) {
             log.error("{} 获取长沙株洲两市数据失败 ",getClass(),e);
             throw e;
         }

         //获取月份列表
         List<String> monthList=targetList.stream().map(i->i.getMonth()).collect(Collectors.toList());



         //先筛选城市名，取AQI数据
         List<Integer> changShaAqiList= targetList.stream()
                 .filter(i->i.getCityName().equals("长沙"))
                 .map(i->i.getAqi())
                 .collect(Collectors.toList());

        List<Integer> zhuZhouAqiList= targetList.stream()
                .filter(i->i.getCityName().equals("株洲"))
                .map(i->i.getAqi())
                .collect(Collectors.toList());

        resultMap.put("monthList",monthList);
        resultMap.put("changShaAqiList",changShaAqiList);
        resultMap.put("zhuZhouAqiList",zhuZhouAqiList);

        return resultMap;

    }

    @Override
    public Map<String, Object> getAqiAvg() {
        List<AqiAvgDTO> targetList=new ArrayList<>();
        Map<String,Object> resultMap=new HashMap<>();
        try{
            targetList=cityAirQualityDAO.getCityAqiAvg();
        } catch (Exception e) {
            log.error("{} 获取aqi平均值失败 ",getClass(),e);
            throw e;
        }

        //获取城市名称，y轴
        List<String> cityNameList=targetList.stream().map(i->i.getCityName()).collect(Collectors.toList());

        //获取aqi平均值，x轴
        List<Integer> aqiAvgList=targetList.stream().map(i->i.getAqiAvg()).collect(Collectors.toList());

        resultMap.put("cityNameList",cityNameList);
        resultMap.put("aqiAvgList",aqiAvgList);

        return resultMap;

    }

    @Override
    public Map<String, Object> getPm25Avg() {
        List<Pm25AvgDTO> targetList=new ArrayList<>();
        Map<String,Object> resultMap=new HashMap<>();
        try{
            targetList=cityAirQualityDAO.getCityPm25Avg();
        } catch (Exception e) {
            log.error("{} 获取pm2.5平均值失败 ",getClass(),e);
            throw e;
        }

        //获取城市名称，y轴
        List<String> cityNameList=targetList.stream().map(i->i.getCityName()).collect(Collectors.toList());

        //获取pm2.5平均值，x轴
        List<Integer> pm25AvgList=targetList.stream().map(i->i.getPm25Avg()).collect(Collectors.toList());

        resultMap.put("cityNameList",cityNameList);
        resultMap.put("pm25AvgList",pm25AvgList);

        return resultMap;

    }
}
