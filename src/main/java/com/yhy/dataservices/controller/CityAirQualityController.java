package com.yhy.dataservices.controller;

import com.yhy.dataservices.service.CityAirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class CityAirQualityController {

    @Autowired
    CityAirQualityService cityAirQualityService;

    @GetMapping("/getCityAqi")
    @ResponseBody
    public Map<String,Object> getCityAqi(){
        return  cityAirQualityService.getCityAqi();
    }


    @GetMapping("/getAqiAvg")
    @ResponseBody
    public Map<String,Object> getAqiAvg(){
        return cityAirQualityService.getAqiAvg();
    }

    @GetMapping("/getPm25Avg")
    @ResponseBody
    public Map<String,Object> getPm25Avg(){
        return cityAirQualityService.getPm25Avg();
    }
}
