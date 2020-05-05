package com.myboot.cmms.mapper.system.role;

import com.myboot.cmms.model.system.role.SysRole;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    //根据查询条件查询角色列表
    List<SysRole> selectRoleListByCondition(SysRole record);

    //根据角色code查询角色
    List<SysRole> selectRoleListByRoleCode(String roleCode);
}
