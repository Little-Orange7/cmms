package com.myboot.cmms.controller.system.org;

import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.model.system.org.SysOrg;
import com.myboot.cmms.model.system.user.SysUser;
import com.myboot.cmms.service.system.org.OrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/org")
public class OrgController {
    private static final Logger logger = LoggerFactory.getLogger(OrgController.class);
    @Resource
    private OrgService orgService;

    /**
     * 机构管理---查询全部组织机构tree
     *
     * @return
     */
    @GetMapping("/getAllOrgTree")
    public RespResult getAllOrgTree() {
        //从根目录开始查询，则得到全部的机构tree
        int pid = -1;
        List<SysOrg> list = orgService.getOrgTreeByParentId(pid);
        return RespResult.success(list);
    }

    /**
     * 新增机构
     *
     * @param org
     * @return
     */
    @PostMapping("/addOrg")
    public RespResult addOrg(@RequestBody SysOrg org) {
        logger.info("addOrg===>org:{}", org);
        int n = orgService.addOrg(org);
        if (n == 1) {
            return RespResult.success("添加成功!");
        }
        return RespResult.fail("添加失败!");
    }

    /**
     * 修改机构信息---根据机构id修改机构信息
     *
     * @param org
     * @return
     */
    @PostMapping("/editOrgInfoByOid")
    public RespResult editOrgInfoByOid(@RequestBody SysOrg org) {
        int n = orgService.editOrgInfoByOid(org);
        if (n == 1) {
            return RespResult.success("修改成功!");
        }
        return RespResult.fail("修改失败!");
    }

    /**
     * 删除机构---根据id删除机构信息
     *
     * @param map
     * @return
     */
    @PostMapping("/deleteOrgByOid")
    public RespResult deleteOrgByOid(@RequestBody Map<String, Object> map) {
        logger.info("deleteOrgByOid===>map:{}", map);
        Integer id = (Integer) map.get("id");
        //根目录不允许被删除
        if (id == 1) {
            return RespResult.fail("根目录不允许被删除!");
        }
        // 如果有子目录，则不允许删除
        List<SysOrg> orgList = orgService.getOrgTreeByParentId(id);
        if (orgList != null && !orgList.isEmpty()) {
            return RespResult.fail("机构下有子部门!");
        }
        //如果部门下有用户，也不允许被删除
        List<SysUser> userList = orgService.selectUserByOrgId(id);
        if (userList != null && !userList.isEmpty()) {
            return RespResult.fail("机构下有用户!");
        }
        int n = orgService.deleteOrgByOid(id);
        if (n == 1) {
            return RespResult.success("删除成功!");
        }
        return RespResult.fail("删除失败!");
    }

}
