package com.yhy.dataservices.service;

import javax.servlet.http.HttpSession;


public interface UserService {
    /**
     * 用户登录
     * @param userName
     */
     Boolean userLogin(HttpSession session,String userName, String passWord);

    /**
     * 修改密码
     * @param id
     * @param passWord
     * @return
     */
     Boolean changePassWord(Integer id,String passWord);
}
