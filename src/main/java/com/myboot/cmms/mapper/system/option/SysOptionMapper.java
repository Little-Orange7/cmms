package com.myboot.cmms.mapper.system.option;

import com.myboot.cmms.model.system.option.SysOption;

import java.util.List;

public interface SysOptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOption record);

    int insertSelective(SysOption record);

    SysOption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOption record);

    int updateByPrimaryKey(SysOption record);

    //根据selectCode查询下拉option
    List<SysOption> selectOptionListBySelectCode(String code);

    //根据selectId查询Option
    List<SysOption> selectOptionListBySelectId(Integer id);
}
