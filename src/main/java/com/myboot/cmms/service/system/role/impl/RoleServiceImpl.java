package com.myboot.cmms.service.system.role.impl;

import com.myboot.cmms.mapper.system.role.SysRoleMapper;
import com.myboot.cmms.model.system.role.SysRole;
import com.myboot.cmms.service.system.role.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> selectRoleListByCondition(SysRole role) {
        return sysRoleMapper.selectRoleListByCondition(role);
    }

    @Override
    public int addRole(SysRole role) {
        return sysRoleMapper.insertSelective(role);
    }

    @Override
    public int deleteRoleByRid(Integer rid) {
        return sysRoleMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public List<SysRole> selectRoleByRoleCode(String roleCode) {
        return sysRoleMapper.selectRoleListByRoleCode(roleCode);
    }

    @Override
    public int editRoleByRid(SysRole role) {
        return sysRoleMapper.updateByPrimaryKeySelective(role);
    }
}
