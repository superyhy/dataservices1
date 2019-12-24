package com.yhy.dataservices.controller;

import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.entity.Role;
import com.yhy.dataservices.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AccessController {

    @Autowired
    AccessService accessService;

    /**
     * 分页查询角色列表
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/getRoleList")
    @ResponseBody
    public PageInfo<Role> getRoleList(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize,
                                      @RequestParam("name") String name){
        return accessService.getRoleList(pageNum, pageSize, name);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    @ResponseBody
    public Map<String,Object> addRoleList(@RequestBody Role role){
        return accessService.addRole(role);
    }
}
