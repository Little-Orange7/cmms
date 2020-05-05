package com.myboot.cmms.service.system.common.impl;

import com.myboot.cmms.common.util.MD5Util;
import com.myboot.cmms.mapper.system.common.CommonMapper;
import com.myboot.cmms.mapper.system.menu.SysMenuMapper;
import com.myboot.cmms.mapper.system.user.SysUserMapper;
import com.myboot.cmms.model.system.menu.SysMenu;
import com.myboot.cmms.model.system.user.SysUser;
import com.myboot.cmms.service.system.common.CommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {
    @Resource
    private CommonMapper commonMapper;
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 根据UserId查询其拥有的所有角色role下的菜单权限的并集的菜单tree（可以是多角色）
     * @param uid
     * @return
     */
    @Override
    public List<SysMenu> selectAllMenusByUid(Integer uid) {
        SysMenu sysMenu=recursiveTreeDataByUserId(uid,1);
        if(sysMenu==null){
            return null;
        }
        //根菜单层级不展示，只展示根菜单下的子菜单信息
        List<SysMenu> list=sysMenu.getChildren();
        return list;
    }

    /**
     * 登录
     * 设置session的过期时间
     * @param loginName
     * @return
     */
    @Override
    public SysUser login(String loginName) {
        SysUser sysUser=sysUserMapper.selectUserByLoginName(loginName);
        return sysUser;
    }

    @Override
    public Object logout(HttpServletRequest request) {
        HttpSession session = request.getSession();        // 将用户信息从session中删除
        session.removeAttribute("userInfo");
        Object userInfo = session.getAttribute("userInfo");
        return userInfo;
    }

    @Override
    public int modifyPwd(String loginName, String pwd) {
        return sysUserMapper.updataPwdByLoginName(loginName,MD5Util.encodeMd5(pwd));
    }

    // 递归，根据菜单根id及Userid查询role下的菜单（可以是多角色）
    private SysMenu recursiveTreeDataByUserId(int uid,int id){
        //根据id查询本级菜单路由信息
        SysMenu routerInfo=commonMapper.getRolesMenuByUserId(uid,id);
        //查询该id下对应的所有的子菜单路由信息
        List<SysMenu> list =commonMapper.getRolesMenusByUserPid(uid,id);
        //遍历子节点
        for(SysMenu rif:list){
            SysMenu n=recursiveTreeDataByUserId(uid,rif.getId());
            routerInfo.getChildren().add(n);
        }
        return routerInfo;
    }
}
