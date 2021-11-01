package com.myboot.cmms.service.system.menu.impl;

import com.myboot.cmms.mapper.system.menu.SysMenuMapper;
import com.myboot.cmms.model.system.menu.FullMenu;
import com.myboot.cmms.model.system.menu.SysMenu;
import com.myboot.cmms.service.system.menu.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> getMenusTreeByParentId(Integer pid) {
        return sysMenuMapper.selectMenusTreeByParentId(pid);
    }

    @Override
    public int addMenu(FullMenu menu,HttpServletRequest request) {
        menuDataHandle(menu,request);
        return sysMenuMapper.insertSelective(menu);
    }

    @Override
    public int deleteMenuById(Integer id) {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public FullMenu selectMenuInfoByMid(Integer id) {
        return sysMenuMapper.selectMenuInfoByMid(id);
    }

    @Override
    public int editMenuInfoByMid(FullMenu menu,HttpServletRequest request) {
        menuDataHandle(menu,request);
        return sysMenuMapper.updateByIdSelective(menu);
    }

    /**
     * 菜单路径数据处理
     * @param menu
     * @param request
     */
    private void menuDataHandle(FullMenu menu,HttpServletRequest request){
        String userInfo=(String) request.getSession().getAttribute("userInfo");
        System.out.println("userInfo:"+userInfo);
        //登录用户处理

        //菜单处理
        if (menu.getFolder()) {//是文件夹，不用解析url
            if (menu.getParentId() == 1) {//一级菜单,必须固定是这个路由
                menu.setComponent("/Layout.vue");
                menu.setName("Layout");
                menu.setPath("/");
            } else {
                menu.setComponent("/system/settings/common/Folder.vue");//文件夹
                menu.setName("Folder");
                menu.setPath("/system/settings/common/Folder");
            }
            menu.setCreateUser(userInfo.substring(0,userInfo.indexOf(",")));
        } else {//是菜单,需要解析url，注意，此处默认只能解析views下的页面，所以，所有的业务页面都要写在views下
            //url:   '/views/emp/basic/EmpBasic.vue'
            //component:  /emp/basic/EmpBasic.vue
            //path:   /emp/basic/EmpBasic
            String url = menu.getUrl();
            int startIndex = url.indexOf('/', 1);
            String path = url.substring(startIndex, url.indexOf(".vue"));
            String component = url.substring(startIndex);
            menu.setComponent(component);//组件
            menu.setPath(path);//组件path
            int lastIndex = url.lastIndexOf('/');
            String name = url.substring(lastIndex + 1, url.indexOf(".vue"));//组件名称
            menu.setName(name);
            menu.setUpdateUser(userInfo.substring(0,userInfo.indexOf(",")));
        }
    }
}
