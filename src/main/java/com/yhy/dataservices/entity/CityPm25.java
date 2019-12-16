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
public class CityPm25 {

  private long id;

  private String cityName;

  private String pm25;

  private Date createTime;


}
