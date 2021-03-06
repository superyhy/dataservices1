package com.yhy.dataservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 用户权限列表的DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccessDTO {

    //用户表主键ID
    private Integer id;

    private String userName;

    private String roleName;

    private String role;

    private String roleDescribe;

}
