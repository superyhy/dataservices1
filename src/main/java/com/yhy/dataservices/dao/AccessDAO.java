package com.yhy.dataservices.dao;

import com.yhy.dataservices.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessDAO {

    /**
     *查询 Role 列表
     * @param name
     * @return
     */
   List<Role> getRoleList(@Param("name") String name);

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
}
