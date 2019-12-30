package com.yhy.dataservices.dao;

import com.yhy.dataservices.dto.UserDTO;
import com.yhy.dataservices.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    /**
     * 用户登录
     * @param username
     * @return
     */
    UserDTO UserLogin(String username);

    /**
     * 修改密码
     * @param id
     * @param passWord
     * @return
     */
    Boolean changePassWord(@Param("id") Integer id,@Param("passWord") String passWord);
}
