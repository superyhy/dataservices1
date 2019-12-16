package com.yhy.dataservices.dao;

import com.yhy.dataservices.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    /**
     * 用户登录
     * @param username
     * @return
     */
    User UserLogin(String username);
}
