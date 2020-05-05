package com.myboot.cmms.service.system.menu;

import com.myboot.cmms.model.system.menu.FullMenu;
import com.myboot.cmms.model.system.menu.SysMenu;

import java.util.List;

public interface MenuService {
    // 根据parentId查询所有本菜单及其所有的子菜单
    List<SysMenu> getMenusTreeByParentId(Integer pid);

    //添加菜单
    int addMenu(FullMenu menu);

    //根据id删除对应菜单
    int deleteMenuById(Integer id);

    //根据id查询对应的菜单信息
    FullMenu selectMenuInfoByMid(Integer id);

    int editMenuInfoByMid(FullMenu menu);
}
