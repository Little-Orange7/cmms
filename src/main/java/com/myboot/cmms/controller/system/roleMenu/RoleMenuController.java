package com.myboot.cmms.controller.system.roleMenu;

import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.service.system.roleMenu.RoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/roleMenu")
public class RoleMenuController {
    private static final Logger logger = LoggerFactory.getLogger(RoleMenuController.class);
    @Resource
    private RoleMenuService roleMenuService;

    /**
     * 角色菜单权限查询---根据角色id查询对应的所拥有的所有菜单id
     * @param map
     * @return
     */
    @PostMapping("/selectMidsByRid")
    public RespResult selectMidsByRid(@RequestBody Map<String, Object> map){
        logger.info("selectRidsByUid===>map:{}",map);
        Integer rid=(Integer) map.get("rid");
        List<Integer> list = roleMenuService.selectMidsByRid(rid);
        logger.info("selectRidsByUid===>list:{}",list);
        return RespResult.success(list);
    }

    /**
     * 角色菜单权限修改---增加该角色所选择的菜单ids
     * @param map
     * @return
     */
    @PostMapping("/modifyMidsByRid")
    public RespResult modifyMidsByRid(@RequestBody Map<String, Object> map){
        logger.info("modifyMidsByRid===>map:{}",map);
        Integer rid=(Integer) map.get("rid");
        String midStr=(String)map.get("mid");
        logger.info("rid:{},mid:{}",rid,midStr);
        String[] midsStr=midStr.split(",");
        logger.info("modifyMidsByRid===>rid:{},midStr:{}",rid,midStr);
        Integer[] mids=null;
        if(midsStr.length==1&&"".equals(midsStr[0])){
            mids=new Integer[0];
        }else{
            mids=new Integer[midsStr.length];
            for(int i=0;i<mids.length; i++){
                System.out.println(midsStr[i]);
                mids[i]=Integer.parseInt(midsStr[i]);
            }
        }
        boolean result=roleMenuService.modifyMidsByRid(rid,mids);
        if(result){
            return RespResult.success("修改成功!");
        }
        return RespResult.fail("修改失败!");
    }
}
