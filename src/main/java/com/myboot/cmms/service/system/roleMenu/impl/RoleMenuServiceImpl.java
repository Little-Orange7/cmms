package com.myboot.cmms.service.system.roleMenu.impl;

import com.myboot.cmms.mapper.system.roleMenu.SysRoleMenuMapper;
import com.myboot.cmms.service.system.roleMenu.RoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    private static final Logger logger = LoggerFactory.getLogger(RoleMenuServiceImpl.class);
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    @Transactional
    public boolean modifyMidsByRid(Integer rid, Integer[] mids) {
        sysRoleMenuMapper.deleteMidsByRid(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer n = sysRoleMenuMapper.addMidsByRid(rid, mids);
        return n == mids.length;
    }

    @Override
    public List<Integer> selectMidsByRid(Integer rid) {
        return sysRoleMenuMapper.selectMidsByRid(rid);
    }
}
