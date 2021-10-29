package com.myboot.cmms.controller.system.user;

import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.model.system.user.SysUser;
import com.myboot.cmms.service.system.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 用户列表查询--可根据查询条件
     *
     * @param sysUser
     * @return
     */
    @PostMapping("/searchUserListByCondition")
    public RespResult searchUserListByCondition(@RequestBody SysUser sysUser) {
        logger.info("searchUserListByCondition=====>sysUser:{}", sysUser);
        List<SysUser> list = userService.searchUserListByCondition(sysUser);
        return RespResult.success(list);
    }

    /**
     * 添加用户
     *
     * @return
     */
    @PostMapping("/addUser")
    public RespResult addUser(@RequestBody SysUser sysUser) {
        logger.info("addUser=====>sysUser:{}", sysUser);
        int n = userService.addUser(sysUser);
        if (n == 1) {
            return RespResult.success("添加成功!");
        }
        return RespResult.fail("添加失败!");
    }

    /**
     * 删除用户---根据用户id
     *
     * @param map
     * @return
     */
    @PostMapping("/deleteUserByUid")
    public RespResult deleteUserByUid(@RequestBody Map<String, Object> map) {
        logger.info("addUser=====>map:{}", map);
        Integer uid = (Integer) map.get("id");
        int n = userService.deleteUserByUid(uid);
        if (n == 1) {
            return RespResult.success("删除成功!");
        }
        return RespResult.fail("删除失败!");
    }

    /**
     * 修改用户信息---根据用户id
     *
     * @param sysUser
     * @return
     */
    @PostMapping("/editUserInfoByUid")
    public RespResult editUserInfoByUid(@RequestBody SysUser sysUser) {
        int n = userService.editUserInfoByUid(sysUser);
        if (n == 1) {
            return RespResult.success("修改成功!");
        }
        return RespResult.fail("修改失败!");
    }
}
