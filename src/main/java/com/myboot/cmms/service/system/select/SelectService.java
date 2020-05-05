package com.myboot.cmms.service.system.select;

import com.myboot.cmms.model.system.select.SysSelect;

import java.util.List;

public interface SelectService {
    /**
     * 根据查询条件查询select列表（支持模糊查询）
     * @param select
     * @return
     */
    List<SysSelect> getSelectListByCondition(SysSelect select);

    /**
     * 根据selectCode查询select
     * @param code
     * @return
     */
    SysSelect selectBySelectCode(String code);

    /**
     * 新增select
     * @param select
     * @return
     */
    int addSelect(SysSelect select);

    /**
     * 修改select
     * @param select
     * @return
     */
    int modifySelectById(SysSelect select);

    /**
     * 删除select
     * 根据id删除select
     * @param id
     * @return
     */
    int deleteSelectById(Integer id);
}
