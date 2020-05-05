package com.myboot.cmms.controller.system.userRole;

import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.service.system.userRole.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/userRole")
public class UserRoleController {
    private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);
    @Resource
    private UserRoleService userRoleService;

    /**
     * 用户角色权限配置---根据用户id查询其拥有的所有的角色id
     * @param map
     * @return
     */
    @PostMapping("/selectRidsByUid")
    public RespResult selectRidsByUid(@RequestBody Map<String,Object> map){
        logger.info("selectRidsByUid===map:{}",map);
        Integer uid=(Integer) map.get("id");
        List<Integer> list=userRoleService.selectRidsByUid(uid);
        logger.info("selectRidsByUid=====>list:{}",list);
        return RespResult.success(list);
    }

    /**
     * 用户角色权限配置---修改用户拥有的角色id
     * @param map
     * @return
     */
    @PostMapping("/modifyRidsByUid")
    public RespResult modifyRidsByUid(@RequestBody Map<String,Object> map){
        logger.info("modifyRidsByUid=====>map:{}",map);
        Integer uid=(Integer) map.get("uid");
        String ridStr=(String)map.get("rids");
        String[] ridsStr=ridStr.split(",");//注意，如果只有一个,则分割出来还是本身，如果是空字符串，则分割后还是空字符串,长度是1
        Integer[] rids=null;
        if(ridsStr.length==1&&"".equals(ridsStr[0])){
            rids=new Integer[0];
        }else{
            rids=new Integer[ridsStr.length];
            logger.info("modifyRidsByUid=====>uid:{},uid:{}",uid,rids);
            for(int i=0;i<rids.length; i++){
                System.out.println(ridsStr[i]);
                rids[i]=Integer.parseInt(ridsStr[i]);
            }
        }
        boolean result=userRoleService.modifyRidsByUid(uid,rids);
        if(result){
            return RespResult.success("修改成功!");
        }
        return RespResult.fail("修改失败!");
    }

}
