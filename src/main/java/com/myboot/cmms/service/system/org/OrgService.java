package com.myboot.cmms.service.system.org;

import com.myboot.cmms.model.system.org.SysOrg;
import com.myboot.cmms.model.system.user.SysUser;

import java.util.List;

public interface OrgService {

    /**
     * 获取所有机构的tree
     * @return
     */
    List<SysOrg> getOrgTreeByParentId(Integer pid);

    /**
     * 新增机构
     * @param org
     * @return
     */
    int addOrg(SysOrg org);

    /**
     * 修改机构信息---根据机构id修改机构信息
     * @param org
     * @return
     */
    int editOrgInfoByOid(SysOrg org);

    /**
     * 删除机构---根据id删除机构信息
     * @param id
     * @return
     */
    int deleteOrgByOid(Integer id);

    /**
     * 根据机构id查询其下的用户
     * @param id
     * @return
     */
    List<SysUser> selectUserByOrgId(Integer id);

}
