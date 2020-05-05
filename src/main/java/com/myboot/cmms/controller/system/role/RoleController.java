package com.myboot.cmms.controller.system.role;

import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.model.system.role.SysRole;
import com.myboot.cmms.service.system.role.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/role")
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Resource
    private RoleService roleService;

    /**
     * 根据查询条件，查询角色列表
     * @return
     */
    @PostMapping("/searchRoleListByCondition")
    public RespResult searchRoleListByCondition(@RequestBody SysRole role){
        logger.info("======searchRoleListByCondition:[{}]",role);
        List<SysRole> list=roleService.selectRoleListByCondition(role);
        logger.info("======searchRoleListByCondition   list:[{}]",list);
        return RespResult.success(list);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    public RespResult addRole(@RequestBody SysRole role){
        logger.info("======addRole:[{}]",role);
        int n=roleService.addRole(role);
        if(n==1){
            return RespResult.success("新增成功!");
        }else{
            return RespResult.fail("新增失败!");
        }
    }

    /**
     * 根据角色id删除角色
     * @param map
     * @return
     */
    @PostMapping("/deleteRoleByRid")
    public RespResult deleteRoleByRid(@RequestBody Map<String,Object> map){
        logger.info("======map:{}",map);
        Integer id=(Integer)map.get("id");
        int n=roleService.deleteRoleByRid(id);
        if(n==1){
            return RespResult.success("删除成功!");
        }else{
            return RespResult.fail("删除失败!");
        }
    }

    /**
     * 修改角色信息---角色码不能重复
     * @param role
     * @return
     */
    @PostMapping("/editRoleByRid")
    public RespResult editRoleByRid(@RequestBody SysRole role){
        logger.info("======editRoleByRid:[{}]",role);
        List<SysRole> list=roleService.selectRoleByRoleCode(role.getRoleCode());
        logger.info("======editRoleByRid  list:[{}]",list);
        if(!list.isEmpty()){
            return RespResult.fail("角色码已经存在！");
        }
        int n=roleService.editRoleByRid(role);
        if(n==1){
            return RespResult.success("修改成功!");
        }
        return RespResult.fail("修改失败!");
    }

}
