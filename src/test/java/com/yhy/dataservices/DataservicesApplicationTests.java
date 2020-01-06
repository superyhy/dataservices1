package com.yhy.dataservices;

import com.yhy.dataservices.dao.AccessDAO;
import com.yhy.dataservices.dao.CityAirQualityDAO;
import com.yhy.dataservices.dao.UserDAO;
import com.yhy.dataservices.dto.cityAirQuality.AqiAvgDTO;
import com.yhy.dataservices.dto.cityAirQuality.Pm25AvgDTO;
import com.yhy.dataservices.entity.CityAirQuality;
import com.yhy.dataservices.entity.Role;
import com.yhy.dataservices.entity.User;
import com.yhy.dataservices.service.AccessService;
import com.yhy.dataservices.service.AirQualityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class DataservicesApplicationTests {
    @Autowired
    UserDAO userDAO;

    @Autowired
    AirQualityService airQualityService;

    @Autowired
    AccessService accessService;

    @Autowired
    AccessDAO accessDAO;

    @Autowired
    CityAirQualityDAO cityAirQualityDAO;


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

    @Test
    public void accessTest(){
        String name="小";
        accessService.getRoleList(1,2,name);

        log.info("------检查角色名称的操作开始-----");
        accessDAO.checkRoleExist(name);

        Role role=new Role();
    }

    @Test
    public void userTest(){
        User user=new User();
        user.setUsername("我是谁");
        user.setPassword("1213");
        user.setIsAble(1);
        user.setRoleId(2);
        userDAO.addUser(user);
        int count=userDAO.checkUserName("皮卡丘");
        System.out.println("用户名数量为"+count);
    }

    @Test
   public void cityAirQualityTest(){
        List<String> cityNames = new ArrayList<>();
        cityNames.add("长沙");
        cityNames.add("株洲");
        List<CityAirQuality> resultList=new ArrayList<>();
        resultList=cityAirQualityDAO.getCityAirQualityByCityName(cityNames);
        System.out.println(resultList);

        List<AqiAvgDTO> AqiAvgList=new ArrayList<>();
        AqiAvgList=cityAirQualityDAO.getCityAqiAvg();
        for(int i=0;i<AqiAvgList.size();i++){
            System.out.println(AqiAvgList.get(i));
        }

        List<Pm25AvgDTO> Pm25AvgList=null;
        Pm25AvgList=cityAirQualityDAO.getCityPm25Avg();
        for(int i=0;i<Pm25AvgList.size();i++){
            System.out.println(Pm25AvgList.get(i));
        }
   }
}
