package com.yhy.dataservices.dto.cityAirQuality;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 城市aqi平均值的DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AqiAvgDTO {

    private String cityName;

    private Integer  aqiAvg;
}
