package com.myboot.cmms.service.system.userRole.impl;

import com.myboot.cmms.mapper.system.userRole.SysUserRoleMapper;
import com.myboot.cmms.service.system.userRole.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<Integer> selectRidsByUid(Integer uid) {
        return sysUserRoleMapper.selectRidsByUid(uid);
    }

    @Override
    @Transactional
    public boolean modifyRidsByUid(Integer uid, Integer[] rids) {
        sysUserRoleMapper.deleteRidsByUid(uid);
        if (rids == null || rids.length == 0) {
            return true;
        }
        int n = sysUserRoleMapper.updateRidsByUid(uid, rids);
        return n == rids.length;
    }
}
