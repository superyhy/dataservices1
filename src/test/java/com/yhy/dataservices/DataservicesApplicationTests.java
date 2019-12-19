package com.yhy.dataservices;

import com.yhy.dataservices.dao.AirQualityDAO;
import com.yhy.dataservices.dao.UserDAO;
import com.yhy.dataservices.service.AirQualityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataservicesApplicationTests {
    @Autowired
    UserDAO userDAO;

    @Autowired
    AirQualityService airQualityService;

    @Test
    public void userLoginTest(){
        String userName="yuhanyi";
        userDAO.UserLogin(userName);
    }

    @Test
    public void airQualityServiceTest(){
        Integer id=1;
        airQualityService.getAirQualityById(id);
    }

}
