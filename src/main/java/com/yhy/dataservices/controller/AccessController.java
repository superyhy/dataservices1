package com.yhy.dataservices.controller;

import com.github.pagehelper.PageInfo;
import com.yhy.dataservices.dto.ChangeRoleDTO;
import com.yhy.dataservices.dto.UpdateUserAccessRequestDTO;
import com.yhy.dataservices.dto.UserAccessDTO;
import com.yhy.dataservices.entity.Role;
import com.yhy.dataservices.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
                                      @RequestParam("roleName") String roleName){
        return accessService.getRoleList(pageNum, pageSize, roleName);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    @ResponseBody
    public Map<String,Object> addRole(@RequestBody Role role){
        return accessService.addRole(role);
    }


    /**
     * 删除角色
     * @param id
     * @return
     */
    @GetMapping("/deleteRole/{id}")
    @ResponseBody
    public Boolean deleteRole(@PathVariable Integer id){
        return accessService.deleteRole(id);
    }

    /**
     * 根据Id，获取role
     * @param id
     * @return
     */
    @GetMapping("/getRoleById/{id}")
    @ResponseBody
    public Role getRoleById(@PathVariable Integer id){
        return accessService.getRoleById(id);
    }

    /**
     * 更新角色
     * @param role
     * @return
     */
    @PostMapping("/updateRole")
    @ResponseBody
    public Map<String, Object> updateRole(@RequestBody Role role){
        return accessService.updateRole(role);
    }

    /**
     * 分页获取用户权限列表
     * @param pageSize
     * @param pageNum
     * @param userName
     * @return
     */
    @GetMapping("/queryUserAccessList")
    @ResponseBody
    public PageInfo<UserAccessDTO> queryUserAccessList(@RequestParam Integer pageSize,
                                                       @RequestParam Integer pageNum,
                                                       @RequestParam String userName){
           return accessService.getUserAccessList(pageSize, pageNum, userName);
    }

    /**
     * 获取角色信息下拉框
     * @return
     */
    @GetMapping("/queryRoleSpinner")
    @ResponseBody
    public List<ChangeRoleDTO> queryRoleSpinner(){
        return accessService.getChangeRoleList();
    }

    /**
     * 修改用户权限
     * @param updateDTO
     * @return
     */
    @PostMapping("/updateUserAccess")
    @ResponseBody
    public Boolean updateUserAccess(@RequestBody UpdateUserAccessRequestDTO updateDTO){
        return accessService.updateUserAccess(updateDTO);
    }

}
