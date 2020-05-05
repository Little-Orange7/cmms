package com.myboot.cmms.mapper.system.user;

import com.myboot.cmms.model.system.user.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    //根据loginName查询user
    SysUser selectUserByLoginName(String loginName);

    //根据查询条件查询用户列表
    List<SysUser> selectUserListByCondition(SysUser record);

    //根据登录名修改密码
    int updataPwdByLoginName(@Param("loginName") String loginName, @Param("loginPwd") String pwd);
}
