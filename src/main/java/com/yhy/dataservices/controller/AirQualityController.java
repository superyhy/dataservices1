package com.yhy.dataservices.controller;

import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.entity.AirQuality;
import com.yhy.dataservices.service.AirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AirQualityController {

    @Autowired
    AirQualityService airQualityService;

    //分页查询
    @GetMapping("/queryAirQuality")
    @ResponseBody
    public PageInfo<AirQuality> queryAirQuality(@RequestParam("pageSize") Integer pageSize,
                                                @RequestParam("pageNum") Integer pageNum,
                                                @RequestParam("cityName") String cityName){
        return  airQualityService.queryAirQuality(pageSize,pageNum,cityName);
    }

    //删除一条数据
    @GetMapping("/deleteAirQuality/{id}")
    @ResponseBody
    public Boolean deleteAirQuality(@PathVariable("id") Integer id){
        return airQualityService.deleteAirQuality(id);
    }
}
