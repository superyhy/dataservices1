package com.yhy.dataservices.service;


import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.entity.Role;

import java.util.Map;

public interface AccessService {

    /**
     * 分页查询角色列表
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo<Role> getRoleList(Integer pageNum, Integer pageSize, String name);

    /**
     * 新增
     * @param role
     * @return
     */
    Map<String,Object> addRole(Role role);
}
