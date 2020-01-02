package com.yhy.dataservices.service;

import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.dto.UserStateDTO;
import com.yhy.dataservices.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


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

    /**
     * 分页查询用户列表
     * @param pageNum
     * @param pageSize
     * @param userName
     * @return
     */
    PageInfo<User> getUserList(Integer pageNum, Integer pageSize, String userName);

    /**
     * 更新用户状态
     * @param userStateDTO
     * @return
     */
    Boolean updateUserState(UserStateDTO userStateDTO);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Map<String,Object> addUser(User user);
}
