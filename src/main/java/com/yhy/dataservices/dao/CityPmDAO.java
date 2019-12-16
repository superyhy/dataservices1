package com.yhy.dataservices.dao;

import com.yhy.dataservices.entity.CityPm25;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityPmDAO {

    /**
     * 获取城市的pm2.5数据
     * @return
     */
    List<CityPm25> getCityPm25List();
}
