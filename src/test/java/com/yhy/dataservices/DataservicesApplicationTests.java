package com.yhy.dataservices;

import com.yhy.dataservices.dao.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataservicesApplicationTests {
    @Autowired
    UserDAO userDAO;
    @Test
    public void userLoginTest(){
        String userName="yuhanyi";
        userDAO.UserLogin(userName);
    }

}
