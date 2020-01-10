package com.yhy.dataservices.controller;


import com.yhy.dataservices.dto.cityAirQuality.EchartsDTO;
import com.yhy.dataservices.service.HengYangAirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HengYangAirQualityController<Lis> {

    @Autowired
    HengYangAirQualityService hengYangAirQualityService;

    /**
     * 2018-2019衡阳市AQI指数走势比较图
     * @return
     */
    @GetMapping("/getAqiFromHengYang")
    @ResponseBody
    public Map<String,Object> getAqiFromHengYang(){
        return  hengYangAirQualityService.getAqiByHengYang();
    }


    /**
     * 2018衡阳市空气质量
     * @return
     */
    @GetMapping("/getAirQualityFrom2018")
    @ResponseBody
    public List<EchartsDTO> getAirQualityFrom2018(){
        return hengYangAirQualityService.getAirQualityFrom2018();
    }

    /**
     * 2019衡阳市空气质量
     * @return
     */
    @GetMapping("/getAirQualityFrom2019")
    @ResponseBody
    public List<EchartsDTO> getAirQualityFrom2019(){
        return hengYangAirQualityService.getAirQualityFrom2019();
    }

    /**
     * 2019衡阳市aqi，PM25，PM10数据
     * @return
     */
    @GetMapping("/getAirQualityByHengYang")
    @ResponseBody
    public Map<String,Object> getAirQualityByHengYang(){
        return hengYangAirQualityService.getAirQualityByHengYang();
    }


    /**
     * 2018衡阳市aqi，PM25数据
     * @return
     */
    @GetMapping("/getPm25AndAqiFrom2018")
    @ResponseBody
    public Map<String,Object> getPm25AndAqiFrom2018(){
        return hengYangAirQualityService.getPm10AndPm25From2018();
    }
}
