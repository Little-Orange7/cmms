package com.myboot.cmms.service.system.user.impl;

import com.myboot.cmms.common.util.MD5Util;
import com.myboot.cmms.mapper.system.user.SysUserMapper;
import com.myboot.cmms.model.system.user.SysUser;
import com.myboot.cmms.service.system.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> searchUserListByCondition(SysUser user) {
        return sysUserMapper.selectUserListByCondition(user);
    }

    @Override
    public int addUser(SysUser user) {
        if("".equals(user.getLoginPwd())||user.getLoginPwd()==null){
            user.setLoginPwd("123456");//如果没有输入密码，则使用默认密码
        }
        user.setLoginPwd(MD5Util.encodeMd5(user.getLoginPwd()));
        return sysUserMapper.insertSelective(user);
    }

    @Override
    public int deleteUserByUid(Integer uid) {
        return sysUserMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int editUserInfoByUid(SysUser user) {
        if(!"".equals(user.getLoginPwd())&&user.getLoginPwd()!=null){
            user.setLoginPwd(MD5Util.encodeMd5(user.getLoginPwd()));
        }
        return sysUserMapper.updateByPrimaryKeySelective(user);
    }
}
