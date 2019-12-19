package com.yhy.dataservices.controller;

import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.entity.AirQuality;
import com.yhy.dataservices.service.AirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AirQualityController {

    @Autowired
    AirQualityService airQualityService;

    /**
     * 分页查询空气质量数据
     * @param pageSize
     * @param pageNum
     * @param cityName
     * @return
     */
    @GetMapping("/queryAirQuality")
    @ResponseBody
    public PageInfo<AirQuality> queryAirQuality(@RequestParam("pageSize") Integer pageSize,
                                                @RequestParam("pageNum") Integer pageNum,
                                                @RequestParam("cityName") String cityName){
        return  airQualityService.queryAirQuality(pageSize,pageNum,cityName);
    }

    /**
     * 删除一条空气质量数据
     * @param id
     * @return
     */
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

    /**
     * 根据ID获取一条空气质量数据
     * @param id
     * @return
     */
    @GetMapping("/getAirQualityById/{id}")
    @ResponseBody
    public AirQuality getAirQualityById(@PathVariable String id){
        return airQualityService.getAirQualityById(Integer.parseInt(id));
    }

    /**
     * 修改一条空气质量数据
     * @param airQuality
     * @return
     */
    @PostMapping("/updateAirQuality")
    @ResponseBody
    public Boolean updateAirQuality(@RequestBody AirQuality airQuality){
          return airQualityService.updateAirQuality(airQuality);
    }

    /**
     * 下载一条空气质量数据
     * @param id
     * @return
     */
    @GetMapping("/downloadAirQuality/{id}")
    @ResponseBody
    public Boolean downloadAirQuality(HttpServletResponse response, @PathVariable Integer id) {
        return airQualityService.downloadAirQuality(response,id);
    }
}
