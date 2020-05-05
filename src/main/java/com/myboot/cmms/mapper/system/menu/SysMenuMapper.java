package com.myboot.cmms.mapper.system.menu;

import com.myboot.cmms.model.system.menu.FullMenu;
import com.myboot.cmms.model.system.menu.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    //实例类是全部的菜单信息
    int insertSelective(FullMenu menu);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    //根据parentId查询菜单树路由信息
    List<SysMenu> selectMenusTreeByParentId(Integer pid);

    //根据id查询对应的菜单信息
    FullMenu selectMenuInfoByMid(Integer id);

    int updateByIdSelective(FullMenu menu);

    //根据id查询本级路由信息

    //查询该id下对应的所有的子路由信息
}
