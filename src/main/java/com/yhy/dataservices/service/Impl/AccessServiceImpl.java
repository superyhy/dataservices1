package com.yhy.dataservices.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.dao.AccessDAO;
import com.yhy.dataservices.dto.ChangeRoleDTO;
import com.yhy.dataservices.dto.UpdateUserAccessRequestDTO;
import com.yhy.dataservices.dto.UserAccessDTO;
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
    public PageInfo<Role> getRoleList(Integer pageNum, Integer pageSize, String roleName) {
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
            resultList=accessDAO.getRoleList(roleName);
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

    @Override
    public Boolean deleteRole(Integer id) {
         boolean flag=true;
         try{
             flag=accessDAO.deleteRole(id);
         } catch (Exception e) {
             log.error("{} 删除角色异常 ",getClass(),e);
             e.printStackTrace();
         }

         return flag;
    }

    @Override
    public Role getRoleById(Integer id) {
        Role role=new Role();
        try{
            role=accessDAO.getRoleById(id);
        } catch (Exception e) {
            log.error("{} 获取role失败 ",getClass(),e);
            e.printStackTrace();
        }
        return role;
    }


    @Override
    public Map<String,Object> updateRole(Role role) {

        Map<String,Object> resultList=new HashMap<>();
        int count=0;
        try{
            count=accessDAO.checkRoleNameExceptMe(role.getRoleName(), (int) role.getId());
        } catch (Exception e) {
            log.info("{} 查询除自已外的角色名，失败 ",getClass(),e);
            e.printStackTrace();
        }
        if(count>0){
            resultList.put("code",401);
            resultList.put("msg","已有其他用户，使用该名称");
            return resultList;
        }
        try{
            accessDAO.updateRole(role);
        } catch (Exception e) {
            log.error("{} 更新角色失败 ",getClass(),e);
            e.printStackTrace();
        }

        resultList.put("code",200);
        resultList.put("msg","操作成功");
        return resultList;
    }

    @Override
    public PageInfo<UserAccessDTO> getUserAccessList(Integer pageSize, Integer pageNum, String userName) {
        List<UserAccessDTO> resultList=new ArrayList<>();

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
            resultList=accessDAO.getUserAccessList(userName);
        } catch (Exception e) {
            log.error("{} 分页查询出现异常 {}",getClass(),e.getMessage());
            e.printStackTrace();
        }

        PageInfo<UserAccessDTO> pageInfo=new PageInfo<>(resultList);

        return pageInfo;
    }

    @Override
    public List<ChangeRoleDTO> getChangeRoleList() {
         List<ChangeRoleDTO> resultList=new ArrayList<>();

         try{
             resultList=accessDAO.getChangeRoleList();
         } catch (Exception e) {
             log.error("{} 获取角色下拉框失败 ",getClass(),e);
             e.printStackTrace();
         }
         return  resultList;
    }

    @Override
    public Boolean updateUserAccess(UpdateUserAccessRequestDTO updateDTO) {
        boolean flag=true;
        try{
            flag=accessDAO.updateUserAccess(updateDTO.getRoleId(),updateDTO.getId());
        } catch (Exception e) {
            log.error("{} 修改用户权限，异常 {}",getClass(),e.getMessage());
            e.printStackTrace();
        }

        return flag;
    }
}
