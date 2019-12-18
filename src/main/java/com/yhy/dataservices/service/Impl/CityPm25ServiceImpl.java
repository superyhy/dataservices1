package com.yhy.dataservices.service.Impl;

import com.yhy.dataservices.dao.CityPmDAO;
import com.yhy.dataservices.entity.CityPm25;
import com.yhy.dataservices.service.CityPm25Service;
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
public class CityPm25ServiceImpl implements CityPm25Service {

    @Autowired
    CityPmDAO cityPmDAO;

    @Override
    public Map<String, Object> getCityPm25List() {

        List<CityPm25> resultList=new ArrayList<>();
        try{
            resultList=cityPmDAO.getCityPm25List();
        } catch (Exception e) {
            log.error("{} 查询城市每月平均PM2.5失败 {}",getClass(),e.getMessage());
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<>();
        List<String> cityNameList=resultList.stream().map(i->i.getCityName()).collect(Collectors.toList());
        List<String> pm25List=resultList.stream().map(i->i.getPm25()).collect(Collectors.toList());
        map.put("cityNameList",cityNameList);
        map.put("pm25List",pm25List);
        return map;
    }
}
