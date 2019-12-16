package com.yhy.dataservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspRedirectController {
    /**
     * 前往主页面
     * @return
     */
    @GetMapping("/gotoIndexPage")
    public String gotoIndexPage(){
        return "index";
    }

    /**
     *
     * @return
     */
    @GetMapping("/gotoScreenPage")
    public String gotoScreenPage(){
        return "screen";
    }

    /**
     * 前往登录页面
     * @return
     */
    @GetMapping("/gotoLoginPage")
    public String gotoLoginPage(){
        return "login";
    }

    /**
     * 前往数据列表页面
     * @return
     */
    @GetMapping("/gotoDataManagerPage")
    public String gotoDataManagerPage(){
        return "datamanager";
    }

    /**
     * 前往新增数据页面
     * @return
     */
    @GetMapping("/gotoCreatePage")
    public String gotoCreatePage(){
        return "create";
    }


}
