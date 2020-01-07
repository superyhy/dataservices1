package com.yhy.dataservices.dto.cityAirQuality;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * echarts饼图中使用的DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EchartsDTO {

    private String name;

    private Integer value;
}
