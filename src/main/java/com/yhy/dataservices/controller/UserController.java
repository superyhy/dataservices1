package com.yhy.dataservices.controller;

import com.yhy.dataservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
        return "login";
    }
}
