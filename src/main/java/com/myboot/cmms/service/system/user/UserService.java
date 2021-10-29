package com.myboot.cmms.service.system.user;

import com.myboot.cmms.model.system.user.SysUser;

import java.util.List;

public interface UserService {

    /**
     * 根据查询条件查询用户列表
     *
     * @param user
     * @return
     */
    List<SysUser> searchUserListByCondition(SysUser user);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(SysUser user);

    /**
     * 根据用户id删除该用户
     *
     * @param uid
     * @return
     */
    int deleteUserByUid(Integer uid);

    /**
     * 修改用户信息---根据用户id
     *
     * @param user
     * @return
     */
    int editUserInfoByUid(SysUser user);

}
