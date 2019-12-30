package com.yhy.dataservices.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  private Integer id;
  private String username;
  private String password;
  private Date createTime;

}
