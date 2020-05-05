package com.myboot.cmms.service.system.roleMenu;

import java.util.List;
import java.util.Map;

public interface RoleMenuService {
    /**
     * 修改角色对应的所有菜单id
     * @param
     * @return
     */
    boolean modifyMidsByRid(Integer rid,Integer[] mids);

    /**
     * 根据角色id查询所拥有的所有菜单id
     * @param rid
     * @return
     */
    List<Integer> selectMidsByRid(Integer rid);
}
