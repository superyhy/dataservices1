package com.yhy.dataservices.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.dao.AirQualityDAO;
import com.yhy.dataservices.entity.AirQuality;
import com.yhy.dataservices.service.AirQualityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class AirQualityServiceImpl implements AirQualityService {

    @Autowired
    AirQualityDAO airQualityDAO;

    @Override
    public PageInfo<AirQuality> queryAirQuality(Integer pageSize, Integer pageNum,String cityName) {

        List<AirQuality> resultList=new ArrayList<>();

        //定义初始化的pageSize，pageNum
        int pageNum1 = 1;
        if(pageNum!=null){ //如果不为空的话改变当前页号
            pageNum1 = pageNum;
        }
        int pageSize1 = 6;
        if(pageSize!=null){ //如果不为空的话改变当前页大小
            pageSize1 =pageSize ;
        }
        //开始分页
        PageHelper.startPage(pageNum1, pageSize1);
        try{
            resultList=airQualityDAO.getAirQualityList(cityName);
        } catch (Exception e) {
            log.error("{} 分页查询出现异常 {}",getClass(),e.getMessage());
            e.printStackTrace();
        }

        PageInfo<AirQuality> pageInfo=new PageInfo<>(resultList);

        return pageInfo;
    }

    @Override
    public Boolean deleteAirQuality(Integer id) {
         boolean flag = true;
         try{
             flag=airQualityDAO.deleteAirQuality(id);
         } catch (Exception e) {
             log.error("{} 删除数据出现异常 {}",getClass(),e.getMessage());
             e.printStackTrace();
         }
         return flag;
    }

    @Override
    public Boolean addAirQuality(AirQuality airQuality) {
        boolean flage=true;
        try{
            flage=airQualityDAO.addAirQuality(airQuality);
        } catch (Exception e) {
            log.error("{} 新增空气质量数据，出现异常 ",getClass(),e);
            e.printStackTrace();
        }
        return flage;
    }

    @Override
    public AirQuality getAirQualityById(Integer id) {
        AirQuality airQuality = null;
        try{
            airQuality=airQualityDAO.getAirQualityById(id);
        } catch (Exception e) {
            log.error("{} 获取一条空气质量数据,失败 ",getClass(),e);
            e.printStackTrace();
        }
        return airQuality;
    }

    @Override
    public Boolean updateAirQuality(AirQuality airQuality) {
        boolean flag=true;
        try{
            flag=airQualityDAO.updateAirQuality(airQuality);
        } catch (Exception e) {
            log.error("{} 修改一条空气质量数据，失败 {}",getClass(),e.getMessage());
            e.printStackTrace();
        }

        return flag;
    }
}
