package com.myboot.cmms.service.system.option;

import com.myboot.cmms.model.system.option.SysOption;

import java.util.List;

public interface OptionService {
    /**
     * 根据selectCode查询Options
     *
     * @param code
     * @return
     */
    List<SysOption> getOptionsBySelectCode(String code);

    /**
     * 根据selectid查询option
     *
     * @param id
     * @return
     */
    List<SysOption> getOptionsBySelectId(Integer id);

    /**
     * 增加Option
     *
     * @param option
     * @return
     */
    int addOption(SysOption option);

    /**
     * 修改option
     *
     * @param option
     * @return
     */
    int modifyOption(SysOption option);

    /**
     * 删除option
     * 根据optionId删除Option
     *
     * @param id
     * @return
     */
    int deleteOptionByOptionId(Integer id);
}
