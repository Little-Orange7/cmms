package com.myboot.cmms.mapper.system.roleMenu;

import com.myboot.cmms.model.system.roleMenu.SysRoleMenu;

import java.util.List;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

    //根据角色id删除其对应的所有菜单id
    int deleteMidsByRid(Integer rid);

    //角色id对应的所有的菜单id
    int addMidsByRid(Integer rid, Integer[] mids);

    //根据角色id查询所拥有的所有菜单id
    List<Integer> selectMidsByRid(Integer rid);
}
