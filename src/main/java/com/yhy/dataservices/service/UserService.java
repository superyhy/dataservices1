package com.yhy.dataservices.service;

import javax.servlet.http.HttpSession;


public interface UserService {
    /**
     * 用户登录
     * @param userName
     */
     Boolean userLogin(HttpSession session,String userName, String passWord);
}
