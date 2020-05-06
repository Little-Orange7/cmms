package com.myboot.cmms.mapper.system.orgUser;

import com.myboot.cmms.model.system.user.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOrgUserMapper {

    //根据机构id查询用户列表
    List<SysUser> selectUserListByOids(@Param("oids") Integer[] oids);

    List<SysUser> selectUserListByOid(Integer oid);
}
