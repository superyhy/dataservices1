package com.yhy.dataservices.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录校验，拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //调用目标方法前请求
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser != null) {
            //已经登录，放行请求
            return true;
        }
           //未登录, 转发到登录页面
        request.setAttribute("msg", "无权限，请登录后访问！");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
        return false;
    }
}
