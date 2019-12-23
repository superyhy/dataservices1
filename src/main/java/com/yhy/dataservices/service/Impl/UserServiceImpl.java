package com.yhy.dataservices.service.Impl;

import com.yhy.dataservices.dao.UserDAO;
import com.yhy.dataservices.dto.UserDTO;
import com.yhy.dataservices.entity.User;
import com.yhy.dataservices.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        UserDTO userDTO = null;
        try {
           userDTO = userDAO.UserLogin(userName);
        } catch (Exception e) {
            log.error("{} 登录时，查询用户信息出现异常 {}",getClass(),e.getMessage());
            e.printStackTrace();
        }
        if(userDTO!=null&&passWord.equals(userDTO.getPassWord())){
            session.setAttribute("loginUser",userDTO.getUserName());
            session.setAttribute("role",userDTO.getRoleName());
            return true;
        }

        return false;

    }
}
