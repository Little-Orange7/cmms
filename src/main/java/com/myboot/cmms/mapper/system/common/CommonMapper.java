package com.myboot.cmms.mapper.system.common;

import com.myboot.cmms.model.system.menu.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonMapper {
    //根据用户uid查询，该用户所拥有的角色对应的菜单并集，菜单id,限定查询的是一条本级菜单信息
    SysMenu getRolesMenuByUserId(@Param("uid") Integer uid, @Param("id") Integer id);

    //根据用户uid查询，该用户所拥有的角色对应的菜单并集，菜单的parentId是查询所有子菜单信息
    List<SysMenu> getRolesMenusByUserPid(@Param("uid") Integer uid, @Param("parentId") Integer pid);
}
