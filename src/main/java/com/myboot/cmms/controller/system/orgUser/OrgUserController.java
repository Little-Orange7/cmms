package com.myboot.cmms.controller.system.orgUser;

import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.model.system.user.SysUser;
import com.myboot.cmms.service.system.orgUser.OrgUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/orgUser")
public class OrgUserController {
    private static final Logger logger = LoggerFactory.getLogger(OrgUserController.class);
    @Resource
    private OrgUserService orgUserService;

    /**
     * 查询所选机构的用户列表
     *
     * @param map
     * @return
     */
    @PostMapping("/searchUserListByOids")
    public RespResult searchUserListByOids(@RequestBody Map<String, Object> map) {
        logger.info("searchUserListByOids====>map:{}", map);
        List<SysUser> list = orgUserService.searchUserListByOids(map);
        return RespResult.success(list);
    }
}
