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

    /**
     * 查询用户列表
     * @param userName
     * @return
     */
    List<User> getUserList(String userName);

    /**
     * 更改用户状态，是否可用
     * @param id
     * @param isAble
     * @return
     */
    Boolean  updateUserState(@Param("id") Integer id,@Param("isAble") Integer isAble);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Boolean addUser(User user);

    /**
     * 新增用户时，判断用户名是否使用
     * @param userName
     * @return
     */
    Integer checkUserName(String userName);
}
