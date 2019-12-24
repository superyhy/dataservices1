package com.yhy.dataservices.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.dao.AccessDAO;
import com.yhy.dataservices.entity.Role;
import com.yhy.dataservices.service.AccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@Slf4j
public class AccessServiceImpl implements AccessService {

    @Autowired
    AccessDAO accessDAO;

    @Override
    public PageInfo<Role> getRoleList(Integer pageNum, Integer pageSize, String name) {
        List<Role> resultList=new ArrayList<>();

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
            resultList=accessDAO.getRoleList(name);
        } catch (Exception e) {
            log.error("{} 分页查询出现异常 {}",getClass(),e.getMessage());
            e.printStackTrace();
        }

        PageInfo<Role> pageInfo=new PageInfo<>(resultList);

        return pageInfo;
    }

    @Override
    public Map<String, Object> addRole(Role role) {
        Map<String,Object> resultMap=new HashMap<>();
        //检查角色的名称是否使用
        int count=0;
        try{
            count=accessDAO.checkRoleExist(role.getRoleName());
        } catch (Exception e) {
            log.error("{} 查询角色的名称，失败 ",getClass(),e);
            e.printStackTrace();
        }

        if(count>0){
            resultMap.put("code",401);
            resultMap.put("msg","该名称已使用");
            return resultMap;
        }


        try{
           accessDAO.addRole(role)  ;
        } catch (Exception e) {
            log.error("{} 新增角色失败 ",getClass(),e);
            e.printStackTrace();
        }

            resultMap.put("code",200);
            resultMap.put("msg","操作成功");

            return resultMap;

    }
}
