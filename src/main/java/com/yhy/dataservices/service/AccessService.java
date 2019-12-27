package com.yhy.dataservices.service;


import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.dto.ChangeRoleDTO;
import com.yhy.dataservices.dto.UpdateUserAccessRequestDTO;
import com.yhy.dataservices.dto.UserAccessDTO;
import com.yhy.dataservices.entity.Role;

import java.util.List;
import java.util.Map;

public interface AccessService {

    /**
     * 分页查询角色列表
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo<Role> getRoleList(Integer pageNum, Integer pageSize, String roleName);

    /**
     * 新增角色,
     * 使用map是为了向前端返回{code，msg}
     * @param role
     * @return
     */
    Map<String,Object> addRole(Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    Boolean deleteRole(Integer id);

    /**
     * 根据Id，获取角色
     * @param id
     * @return
     */
    Role getRoleById(Integer id);

    /**
     * 更新角色
     * @param role
     * @return
     */
    Map<String,Object> updateRole(Role role);

    /**
     * 分页获取用户权限列表
     * @param pageSize
     * @param pageNum
     * @param userName
     * @return
     */
    PageInfo<UserAccessDTO> getUserAccessList(Integer pageSize,Integer pageNum,String userName);

    /**
     * 获取角色的下拉框
     * @return
     */
    List<ChangeRoleDTO> getChangeRoleList();

    /**
     * 修改用户权限
     * @param updateDTO
     * @return
     */
    Boolean updateUserAccess(UpdateUserAccessRequestDTO updateDTO);

}
