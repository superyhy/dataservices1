package com.yhy.dataservices.service.Impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    @Override
    public Boolean downloadAirQuality(HttpServletResponse response,Integer id)  {
        AirQuality airQuality=null;
        try {
            airQuality=airQualityDAO.getAirQualityById(id);
        } catch (Exception e) {
            log.error("{} 下载数据失败 ",getClass() ,e);
            e.printStackTrace();
        }
        Map<String, Object> row1 = new LinkedHashMap<>();
        //Date数据转String
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        row1.put("城市名称", airQuality.getCityName());
        row1.put("空气质量指数（AQI）",airQuality.getAqi());
        row1.put("可入肺颗粒物（PM2.5值）", airQuality.getPm25());
        row1.put("可吸入颗粒物（PM10值）", airQuality.getPm10());
        row1.put("二氧化硫指数（SO2）", airQuality.getSo2());
        row1.put("二氧化氮指数（NO2）", airQuality.getNo2());
        row1.put("创建时间", simpleDateFormat.format(airQuality.getCreateTime()));
        ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1);

     try {
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
       //out为OutputStream，需要写出到的目标流
           //response为HttpServletResponse对象
           response.setContentType("application/vnd.ms-excel;charset=utf-8");
           String fileName = airQuality.getCityName() + ".xls";
           String fileNameURL = URLEncoder.encode(fileName, "UTF-8");
           //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
           response.setHeader("Content-Disposition", "attachment;filename=" + fileNameURL + ";" + "filename*=utf-8''" + fileNameURL);
//           response.setHeader("filename",fileNameURL);
//           response.setHeader("Access-Control-Expose-Headers","filename");
//           response.setHeader("Access-Control-Allow-Origin","*");
           ServletOutputStream out = response.getOutputStream();

           writer.flush(out, true);
           // 关闭writer，释放内存
           writer.close();
           //此处记得关闭输出Servlet流
           IoUtil.close(out);
       } catch (IOException e) {
           log.error("{} 下载失败 ",getClass(),e);
           e.printStackTrace();
       }

        return true;
    }
}
