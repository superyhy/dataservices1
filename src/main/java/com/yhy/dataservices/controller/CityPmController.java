package com.yhy.dataservices.controller;

import com.yhy.dataservices.entity.CityPm25;
import com.yhy.dataservices.service.CityPm25Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CityPmController {

    @Autowired
    CityPm25Service cityPm25Service;

    @GetMapping("/getCityPmList")
    @ResponseBody
    public Map<String,Object>getCityPmList(){
        return cityPm25Service.getCityPm25List();
    }
}
