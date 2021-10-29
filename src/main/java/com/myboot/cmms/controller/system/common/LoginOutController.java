package com.myboot.cmms.controller.system.common;

import com.myboot.cmms.common.util.MD5Util;
import com.myboot.cmms.controller.system.role.RoleController;
import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.model.system.menu.SysMenu;
import com.myboot.cmms.model.system.user.SysUser;
import com.myboot.cmms.service.system.common.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/common")
public class LoginOutController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Resource
    private CommonService commonService;

    /**
     * 登录
     *
     * @return
     */
    @PostMapping("/doLogin")
    public RespResult doLogin(@RequestBody Map<String, Object> loginForm, HttpServletRequest request) {
        logger.info("doLogin====loginForm:[{}]", loginForm);
        String loginName = (String) loginForm.get("loginName");
        String loginPwd = (String) loginForm.get("loginPwd");
        if ("".equals(loginName) || loginForm == null) {
            return RespResult.fail("用户名不能为空!");
        }
        if ("".equals(loginPwd) || loginPwd == null) {
            return RespResult.fail("密码不能为空!");
        }
        SysUser user = commonService.login(loginName);
        if (user == null) {
            return RespResult.fail("该用户名不存在!");
        }
        if (user.getOrgCode().isEmpty()) {
            return RespResult.fail("用户没有所属机构，登录失败!");
        }
        if (MD5Util.verifyMd5(loginPwd, user.getLoginPwd())) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30 * 60);//设置过期时间，以秒为单位
            session.setAttribute("userInfo", loginName + " - " + user.getLoginPwd());
            return RespResult.success("登录成功!", user);
        } else {
            return RespResult.fail("密码错误!");
        }
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/doLogout")
    public RespResult doLogout(HttpServletRequest request) {
        logger.info("doLogout====request:[{}]", request);
        Object user = commonService.logout(request);
        if (user == null) {
            return RespResult.success("退出成功!");
        } else {
            return RespResult.fail("退出失败!");
        }
    }

    /**
     * 查询登录用户菜单---根据用户id，查询用户所有的菜单
     *
     * @return
     */
    @PostMapping("/getAllMenusByUid")
    public RespResult getAllMenusByUid(@RequestBody Map<String, Object> map) {
        logger.info("map:[{}]", map);
        if (map == null || map.get("uid") == null) {
            return RespResult.fail("请求非法!");
        }
        Integer uid = (Integer) map.get("uid");
        List<SysMenu> list = commonService.selectAllMenusByUid(uid);
        if (list == null) {
            return RespResult.fail("用户还没有配置任何菜单，请联系管理员！");
        }
        return RespResult.success(list);
    }

    /**
     * 用户修改密码
     *
     * @param map
     * @return
     */
    @PostMapping("/modifyPwd")
    public RespResult modifyPwd(@RequestBody Map<String, Object> map) {
        logger.info("map:[{}]", map);
        String loginName = (String) map.get("loginName");
        String oldPwd = (String) map.get("oldPwd");
        String newPwd = (String) map.get("newPwd");
        String reNewPwd = (String) map.get("reNewPwd");
        if (!newPwd.equals(reNewPwd)) {
            return RespResult.fail("两次输入的密码不一致!");
        }
        if ("".equals(loginName) || loginName == null) {
            return RespResult.fail("用户登录名为空!");
        }
        SysUser user = commonService.login(loginName);
        if (user == null) {
            return RespResult.fail("该用户登录名不存在!");
        }
        if (!MD5Util.verifyMd5(oldPwd, user.getLoginPwd())) {
            return RespResult.fail("旧密码输入错误!");
        }
        int n = commonService.modifyPwd(loginName, newPwd);
        if (n == 1) {
            return RespResult.success("密码修改成功！");
        } else {
            return RespResult.fail("密码修改失败！");
        }
    }

}
