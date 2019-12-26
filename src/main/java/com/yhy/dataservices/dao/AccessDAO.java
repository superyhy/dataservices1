package com.yhy.dataservices.dao;

import com.yhy.dataservices.dto.UserAccessDTO;
import com.yhy.dataservices.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessDAO {

    /**
     *查询 Role 列表
     * @param roleName
     * @return
     */
   List<Role> getRoleList(@Param("roleName") String roleName);

    /**
     * 检验角色的名称，是否使用
     * @param name
     * @return
     */
   Integer checkRoleExist(String name);

    /**
     * 新增角色
     * @param role
     * @return
     */
   Boolean addRole(Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
   Boolean deleteRole(Integer id);

    /**
     * 根据ID，获取角色
     * @param id
     * @return
     */
   Role getRoleById(Integer id);

    /**
     * 更新角色
     * @param role
     * @return
     */
   Boolean updateRole(Role role);

    /**
     * 更新的时候,检查是否其他role使用了角色名（不包括自己）
     */
   Integer checkRoleNameExceptMe(@Param("roleName") String RoleName,@Param("id") Integer id);


    /**
     * 获取用户权限列表
     * @param userName
     * @return
     */
   List<UserAccessDTO>  getUserAccessList(String userName);

}
