package com.yhy.dataservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccessDTO {

    private String userName;

    private String roleName;

    private String role;

    private String roleDescribe;

}
