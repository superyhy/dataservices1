package com.yhy.dataservices.service.Impl;

import com.yhy.dataservices.dao.CityAirQualityDAO;
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
         List<String> changShaAqiList= targetList.stream()
                 .filter(i->i.getCityName().equals("长沙"))
                 .map(i->i.getAqi())
                 .collect(Collectors.toList());

        List<String> zhuZhouAqiList= targetList.stream()
                .filter(i->i.getCityName().equals("株洲"))
                .map(i->i.getAqi())
                .collect(Collectors.toList());

        resultMap.put("monthList",monthList);
        resultMap.put("changShaAqiList",changShaAqiList);
        resultMap.put("zhuZhouAqiList",zhuZhouAqiList);

        return resultMap;

    }
}
