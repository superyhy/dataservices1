package com.yhy.dataservices.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.dao.UserDAO;
import com.yhy.dataservices.dto.UserAccessDTO;
import com.yhy.dataservices.dto.UserDTO;
import com.yhy.dataservices.dto.UserStateDTO;
import com.yhy.dataservices.entity.User;
import com.yhy.dataservices.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

            session.setAttribute("id",userDTO.getId());
            session.setAttribute("password",userDTO.getPassWord());
            session.setAttribute("loginUser",userDTO.getUserName());
            session.setAttribute("role",userDTO.getRole());
            return true;
        }

        return false;

    }

    @Override
    public Boolean changePassWord(Integer id, String passWord) {
        boolean flag;
        try{
            flag=userDAO.changePassWord(id, passWord);
        } catch (Exception e) {
           log.error("{} 修改密码失败 ",getClass(),e);
           throw e;
        }
        return flag;
    }

    @Override
    public  PageInfo<User> getUserList(Integer pageNum, Integer pageSize, String userName) {
        List<User> resultList;

        //定义初始化的pageSize，pageNum
        int pageNum1 = 1;
        if(pageNum!=null){ //如果不为空的话改变当前页号
            pageNum1 = pageNum;
        }
        int pageSize1 = 4;
        if(pageSize!=null){ //如果不为空的话改变当前页大小
            pageSize1 =pageSize ;
        }
        //开始分页
        PageHelper.startPage(pageNum1, pageSize1);
        try{
            resultList=userDAO.getUserList(userName);
        } catch (Exception e) {
            log.error("{} 分页查询出现异常 {}",getClass(),e.getMessage());
            throw e;
        }

        PageInfo<User> pageInfo=new PageInfo<>(resultList);

        return  pageInfo;
    }

    @Override
    public Boolean updateUserState(UserStateDTO userStateDTO) {
        boolean flag;
        try{
            flag=userDAO.updateUserState(userStateDTO.getId(), userStateDTO.getIsAble());
        } catch (Exception e) {
            log.error("{} 更新用户状态，失败 ",getClass(),e);
            throw e;
        }

        return flag;
    }

    @Override
    public Map<String, Object> addUser(User user) {
        Map<String,Object> resultMap=new HashMap<>();
        int count=0;
        //默认用户状态为可用 1
        user.setIsAble(1);
        try{
            count=userDAO.checkUserName(user.getUsername());
        } catch (Exception e) {
            log.error("{} 查询用户名，失败 ",getClass(),e);
            throw e;
        }
        //判断用户名是否已使用
        if(count>0){
            resultMap.put("code",400);
            resultMap.put("msg","用户名已使用,请重新填写");
            return resultMap;
        }

        try{
            userDAO.addUser(user);
        } catch (Exception e) {
            log.error("{} 新增用户失败 ",getClass(),e);
            throw  e;
        }

        resultMap.put("code",200);
        resultMap.put("msg","操作成功");
        return resultMap;
    }
}
