package com.yhy.dataservices.controller;

import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.dto.UserStateDTO;
import com.yhy.dataservices.entity.User;
import com.yhy.dataservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    @ResponseBody
    public Boolean userLogin(HttpSession session,@RequestParam("username") String userName
            , @RequestParam("password") String passWord){
        return userService.userLogin(session,userName,passWord);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("logout被调用。。。");
        session.removeAttribute("loginUser");
        session.invalidate();
         //回到登录页面
        return "login/login";
    }

    /**
     * 密码修改
     * @param id
     * @param passWord
     * @return
     */
    @GetMapping("/changePassword")
    @ResponseBody
    public Boolean changePassword(@RequestParam Integer id,@RequestParam String passWord){
         return userService.changePassWord(id, passWord);
    }

    /**
     * 分页获取用户列表
     * @param pageSize
     * @param pageNum
     * @param userName
     * @return
     */
    @GetMapping("/getUserList")
    @ResponseBody
    public PageInfo<User> getUserList(@RequestParam Integer pageNum
            ,@RequestParam Integer pageSize,@RequestParam String userName){
        return userService.getUserList(pageNum, pageSize, userName);
    }

    /**
     * 更新用户状态
     * @param userStateDTO
     * @return
     */
    @PostMapping("/updateUserState")
    @ResponseBody
    public Boolean updateUserState(@RequestBody UserStateDTO userStateDTO){
        return userService.updateUserState(userStateDTO);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    @ResponseBody
    public Map<String,Object> addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
