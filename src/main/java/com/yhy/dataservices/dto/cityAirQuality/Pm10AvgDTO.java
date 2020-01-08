package com.yhy.dataservices.dto.cityAirQuality;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 城市Pm10平均值
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pm10AvgDTO {

    private String cityName;

    private Integer pm10Avg;
}
