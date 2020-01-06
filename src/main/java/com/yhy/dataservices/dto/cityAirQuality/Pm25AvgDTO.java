package com.yhy.dataservices.dto.cityAirQuality;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 城市pm2.5平均值的DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pm25AvgDTO {

    private String cityName;

    private Integer pm25Avg;
}
