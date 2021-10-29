package com.myboot.cmms.service.system.role;

import com.myboot.cmms.model.system.role.SysRole;

import java.util.List;

public interface RoleService {
    /**
     * 根据查询条件查询角色列表
     *
     * @param role
     * @return
     */
    List<SysRole> selectRoleListByCondition(SysRole role);

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    int addRole(SysRole role);

    /**
     * 删除角色---根据角色id
     *
     * @param rid
     * @return
     */
    int deleteRoleByRid(Integer rid);

    /**
     * 根据角色码查询角色
     *
     * @return
     */
    List<SysRole> selectRoleByRoleCode(String roleCode);

    /**
     * 修改角色信息
     *
     * @param role
     * @return
     */
    int editRoleByRid(SysRole role);
}
