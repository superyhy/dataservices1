package com.yhy.dataservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 下拉框，角色列表的DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeRoleDTO {

    private Integer id;

    private String roleName;
}
