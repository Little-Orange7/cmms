package com.myboot.cmms.service.system.orgUser;

import com.myboot.cmms.model.system.user.SysUser;

import java.util.List;
import java.util.Map;

public interface OrgUserService {
    /**
     * 根据机构id查询用户列表
     *
     * @param map
     * @return
     */
    List<SysUser> searchUserListByOids(Map<String, Object> map);
}
