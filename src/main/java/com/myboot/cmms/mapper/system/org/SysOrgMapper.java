package com.myboot.cmms.mapper.system.org;

import com.myboot.cmms.model.system.org.SysOrg;
import com.myboot.cmms.model.system.user.SysUser;

import java.util.List;

public interface SysOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    SysOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOrg record);

    int updateByPrimaryKey(SysOrg record);

    //根据pid查询子机构树
    List<SysOrg> selectOrgsTreeByParentId(Integer pid);

    //根据机构id查询机构用户
    List<SysUser> selectUserByOrgId(Integer id);
}
