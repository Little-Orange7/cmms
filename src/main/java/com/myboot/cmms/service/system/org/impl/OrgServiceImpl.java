package com.myboot.cmms.service.system.org.impl;

import com.myboot.cmms.mapper.system.org.SysOrgMapper;
import com.myboot.cmms.model.system.org.SysOrg;
import com.myboot.cmms.model.system.user.SysUser;
import com.myboot.cmms.service.system.org.OrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {
    @Resource
    private SysOrgMapper sysOrgMapper;

    @Override
    public List<SysOrg> getOrgTreeByParentId(Integer pid) {
        return sysOrgMapper.selectOrgsTreeByParentId(pid);
    }

    @Override
    public int addOrg(SysOrg org) {
        return sysOrgMapper.insertSelective(org);
    }

    @Override
    public int editOrgInfoByOid(SysOrg org) {
        return sysOrgMapper.updateByPrimaryKeySelective(org);
    }

    @Override
    public int deleteOrgByOid(Integer id) {
        return sysOrgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysUser> selectUserByOrgId(Integer id) {
        return sysOrgMapper.selectUserByOrgId(id);
    }
}
