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
public class AirQuality {

  private long id;
  private String cityName;
  private String pm25;
  private String pm10;
  private String so2;
  private String no2;
  private Date createTime;
  private Date updateTime;
  private String aqi;

}
