package com.myboot.cmms.service.system.orgUser.impl;

import com.myboot.cmms.mapper.system.orgUser.SysOrgUserMapper;
import com.myboot.cmms.model.system.user.SysUser;
import com.myboot.cmms.service.system.orgUser.OrgUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrgUserServiceImpl implements OrgUserService {
    @Resource
    private SysOrgUserMapper sysOrgUserMapper;

    @Override
    public List<SysUser> searchUserListByOids(Map<String,Object> map) {
        String oidStr=(String)map.get("oids");
        Integer[] oids=null;
        //1.如果传的是非空字符串，则分两种情况：1.1 只有一个值；1.2 多于一个值；
        if(!"".equals(oidStr)){
            String[] oidsStr=oidStr.split(",");//注：如果oidStr是空字符串“”，则分割后的长度是1，分割的字符还是空字符串“”
            //只有一个值的情况
            if(oidsStr.length==1&&!"".equals(oidsStr[0])){
                Integer oid=Integer.parseInt(oidsStr[0]);
                return sysOrgUserMapper.selectUserListByOid(oid);
            }
            //多于一个值的情况
            oids=new Integer[oidsStr.length];
            if(oids.length>1){
                for(int i=0;i<oids.length; i++){
                    oids[i]=Integer.parseInt(oidsStr[i]);
                }
            }
        }else{
            //2 如果传的是一个空字符串，则查询全机构用户
            oids=new Integer[0];
        }
        return sysOrgUserMapper.selectUserListByOids(oids);
    }
}
