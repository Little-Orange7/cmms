package com.myboot.cmms.service.system.option.impl;

import com.myboot.cmms.mapper.system.option.SysOptionMapper;
import com.myboot.cmms.model.system.option.SysOption;
import com.myboot.cmms.service.system.option.OptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    @Resource
    private SysOptionMapper sysOptionMapper;

    @Override
    public List<SysOption> getOptionsBySelectCode(String code) {
        return sysOptionMapper.selectOptionListBySelectCode(code);
    }

    @Override
    public List<SysOption> getOptionsBySelectId(Integer id) {
        return sysOptionMapper.selectOptionListBySelectId(id);
    }

    @Override
    public int addOption(SysOption option) {
        return sysOptionMapper.insertSelective(option);
    }

    @Override
    public int modifyOption(SysOption option) {
        return sysOptionMapper.updateByPrimaryKeySelective(option);
    }

    @Override
    public int deleteOptionByOptionId(Integer id) {
        return sysOptionMapper.deleteByPrimaryKey(id);
    }
}
