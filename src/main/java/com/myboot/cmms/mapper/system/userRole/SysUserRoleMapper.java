package com.myboot.cmms.mapper.system.userRole;

import com.myboot.cmms.model.system.userRole.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    //根据用户id查询其拥有的所有的角色id
    List<Integer> selectRidsByUid(Integer uid);

    //根据用户id删除其拥有的所有的角色id
    int deleteRidsByUid(Integer uid);

    //修改用户拥有的角色id
    int updateRidsByUid(@Param("uid")Integer uid, @Param("rids")Integer[] rids);
}
