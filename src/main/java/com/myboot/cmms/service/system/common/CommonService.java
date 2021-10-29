package com.myboot.cmms.service.system.common;

import com.myboot.cmms.model.system.menu.SysMenu;
import com.myboot.cmms.model.system.user.SysUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface CommonService {
    /**
     * 根据UserId查询其拥有的所有角色role下的菜单权限的并集的菜单tree（可以是多角色）
     *
     * @param uid
     * @return
     */
    List<SysMenu> selectAllMenusByUid(Integer uid);

    /**
     * 根据登录名查询用户信息
     *
     * @param loginName
     * @return
     */
    SysUser login(String loginName);

    /**
     * @param request
     * @return
     */
    Object logout(HttpServletRequest request);

    /**
     * 修改密码
     *
     * @param loginName
     * @param pwd
     * @return
     */
    int modifyPwd(String loginName, String pwd);
}
