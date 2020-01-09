package com.sample;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityAirQuality2018 {

  private long id;
  private String cityName;
  private long month;
  private long aqi;
  private long pm25;
  private long pm10;
  private Date createTime;
  private Date updateTime;

}
