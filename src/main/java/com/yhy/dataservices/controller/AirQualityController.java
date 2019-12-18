package com.yhy.dataservices.controller;

import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.entity.AirQuality;
import com.yhy.dataservices.service.AirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AirQualityController {

    @Autowired
    AirQualityService airQualityService;

    //分页查询空气质量数据
    @GetMapping("/queryAirQuality")
    @ResponseBody
    public PageInfo<AirQuality> queryAirQuality(@RequestParam("pageSize") Integer pageSize,
                                                @RequestParam("pageNum") Integer pageNum,
                                                @RequestParam("cityName") String cityName){
        return  airQualityService.queryAirQuality(pageSize,pageNum,cityName);
    }

    //删除一条空气质量数据
    @GetMapping("/deleteAirQuality/{id}")
    @ResponseBody
    public Boolean deleteAirQuality(@PathVariable("id") Integer id){
        return airQualityService.deleteAirQuality(id);
    }

    /**
     * 新增一条空气质量数据
     * @param airQuality
     * @return
     */
    @PostMapping("/addAirQuality")
    @ResponseBody
    public Boolean addAirQuality(@RequestBody AirQuality airQuality){
        return airQualityService.addAirQuality(airQuality);
    }
}
