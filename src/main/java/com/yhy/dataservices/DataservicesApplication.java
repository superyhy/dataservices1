package com.yhy.dataservices;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yhy.dataservices.dao")
public class DataservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataservicesApplication.class, args);
    }

}
