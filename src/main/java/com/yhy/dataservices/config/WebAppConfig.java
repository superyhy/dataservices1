package com.yhy.dataservices.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 设置默认访问页
 */
@Configuration
public class WebAppConfig   {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer(){
            //添加视图控制
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");


            }


//            //添加拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor())
//           // 拦截所有请求 /**
//                        .addPathPatterns("/**")
//            // 排除不需要拦截的请求
//                        .excludePathPatterns("/", "/login"," "
//                //SpringBoot2+中要排除静态资源路径, 因访问时不会加/static，所以配置如下
//                                ,"/css/**", "/img/**","/js/**");
//            }
        };
        return webMvcConfigurer;
    }



}
