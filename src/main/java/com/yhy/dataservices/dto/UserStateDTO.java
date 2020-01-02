package com.yhy.dataservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改用户状态的DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserStateDTO {
    private Integer id;
    private Integer isAble;
}
