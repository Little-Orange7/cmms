package com.myboot.cmms.service.system.select.impl;

import com.myboot.cmms.mapper.system.select.SysSelectMapper;
import com.myboot.cmms.model.system.select.SysSelect;
import com.myboot.cmms.service.system.select.SelectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SelectServiceImpl implements SelectService {
    @Resource
    private SysSelectMapper sysSelectMapper;

    @Override
    public List<SysSelect> getSelectListByCondition(SysSelect select) {
        return sysSelectMapper.selectListByCondition(select);
    }

    @Override
    public SysSelect selectBySelectCode(String code) {
        return sysSelectMapper.selectBySelectCode(code);
    }

    @Override
    public int addSelect(SysSelect select) {
        return sysSelectMapper.insertSelective(select);
    }

    @Override
    public int modifySelectById(SysSelect select) {
        return sysSelectMapper.updateByPrimaryKeySelective(select);
    }

    @Override
    public int deleteSelectById(Integer id) {
        return sysSelectMapper.deleteByPrimaryKey(id);
    }
}
