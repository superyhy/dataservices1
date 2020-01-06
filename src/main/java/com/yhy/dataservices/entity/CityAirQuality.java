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
public class CityAirQuality {

  private long id;
  private String cityName;
  private String month;
  private Integer aqi;
  private Integer pm25;
  private Integer pm10;
  private Date createTime;
  private Date updateTime;

}
