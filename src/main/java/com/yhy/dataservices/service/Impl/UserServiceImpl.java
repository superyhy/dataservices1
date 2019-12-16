package com.yhy.dataservices.service.Impl;

import com.yhy.dataservices.dao.UserDAO;
import com.yhy.dataservices.entity.User;
import com.yhy.dataservices.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public Boolean userLogin( HttpSession session,String userName,String passWord) {
        User user = null;
        try {
           user = userDAO.UserLogin(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user!=null&&passWord.equals(user.getPassword())){
            session.setAttribute("loginUser",user.getUsername());
            return true;
        }

        return false;
    }
}
