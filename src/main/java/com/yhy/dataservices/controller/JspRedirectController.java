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
        return "index/index";
    }

    /**
     *
     * @return
     */
    @GetMapping("/gotoScreenPage")
    public String gotoScreenPage(){
        return "index/index";
    }

    /**
     * 前往登录页面
     * @return
     */
    @GetMapping("/gotoLoginPage")
    public String gotoLoginPage(){
        return "login/login";
    }

    /**
     * 前往数据列表页面
     * @return
     */
    @GetMapping("/gotoDataManagerPage")
    public String gotoDataManagerPage(){
        return "data/datamanager";
    }

    /**
     * 前往新增数据页面
     * @return
     */
    @GetMapping("/gotoCreatePage")
    public String gotoCreatePage(){
        return "data/create";
    }

    /**
     * 前往新增编辑页面
     * @return
     */
    @GetMapping("/gotoEditPage")
    public String gotoEditPage(){
        return "data/data_edit";
    }

    /**
     *前往衡阳市，数据大屏
     * @return
     */
    @GetMapping("/gotoHengYang")
    public String gotoHengYang(){
        return "hengyang_index/hengyang_index";
    }

    /**
     * 前往角色列表页面
     * @return
     */
    @GetMapping("/gotoRoleList")
    public String gotoRoleList(){
        return "access/roleList";
    }

    /**
     * 前往添加角色页面
     * @return
     */
    @GetMapping("/gotoAddRole")
    public String gotoAddRole(){
        return "access/addRole";
    }

    /**
     * 前往编辑角色页面
     * @return
     */
    @GetMapping("/gotoEditRole")
    public String gotoEditRole(){
        return "access/editRole";
    }

    /**
     * 前往用户权限界面
     * @return
     */
    @GetMapping("/gotoUserAccess")
    public String gotoUserAccess(){
        return "access/userAccess";
    }

    /**
     * 前往用户权限编辑页面
     * @return
     */
    @GetMapping("/gotoUserAccessEdit")
    public String gotoUserAccessEdit(){
        return "access/userAccess_edit";
    }

    /**
     * 前往密码修改页面
     * @return
     */
    @GetMapping("/gotoPassWord")
    public String gotoPassWord(){
        return "user_manager/password";
    }

    /**
     * 前往个人主页
     * @return
     */
    @GetMapping("/gotoPersonalPage")
    public String gotoPersonalPage(){
        return "user_manager/personalDetails";
    }
}
