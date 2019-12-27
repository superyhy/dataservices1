package com.yhy.dataservices.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 修改用户权限时，使用的DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserAccessRequestDTO {

    //用户表主键ID
    private Integer id;

    //角色表主键ID
    private Integer roleId;

}
