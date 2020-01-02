package com.yhy.dataservices;

import com.yhy.dataservices.dao.AccessDAO;
import com.yhy.dataservices.dao.UserDAO;
import com.yhy.dataservices.entity.Role;
import com.yhy.dataservices.entity.User;
import com.yhy.dataservices.service.AccessService;
import com.yhy.dataservices.service.AirQualityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


}
