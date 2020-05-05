package com.myboot.cmms.mapper.system.select;

import com.myboot.cmms.model.system.select.SysSelect;

import java.util.List;

public interface SysSelectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysSelect record);

    int insertSelective(SysSelect record);

    SysSelect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysSelect record);

    int updateByPrimaryKey(SysSelect record);

    //根据查询条件，(支持模糊查询)查询所有的select列表
    List<SysSelect> selectListByCondition(SysSelect record);

    //根据selectCode查询select
    SysSelect selectBySelectCode(String code);
}
