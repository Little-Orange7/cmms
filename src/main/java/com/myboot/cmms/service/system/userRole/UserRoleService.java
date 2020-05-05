package com.myboot.cmms.service.system.userRole;

import java.util.List;
import java.util.Map;

public interface UserRoleService {

    /**
     * 根据用户id查询所有的角色id
     * @param uid
     * @return
     */
    List<Integer> selectRidsByUid(Integer uid);

    /**
     * 修改用户拥有的角色id
     * @param
     * @return
     */
    boolean modifyRidsByUid(Integer uid,Integer[] rids);
}
