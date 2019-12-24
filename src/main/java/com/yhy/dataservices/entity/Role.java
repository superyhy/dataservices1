package com.yhy.dataservices.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

  private long id;
  private String role;
  private String roleDescribe;
  private Date createTime;
  private String roleName;
  private Date updateTime;


}
