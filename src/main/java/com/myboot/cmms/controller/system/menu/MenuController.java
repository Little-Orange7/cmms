package com.myboot.cmms.controller.system.menu;

import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.model.system.menu.FullMenu;
import com.myboot.cmms.model.system.menu.SysMenu;
import com.myboot.cmms.service.system.menu.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    private MenuService menuService;

    /**
     * 菜单管理---查询所有的菜单树
     *
     * @return
     */
    @GetMapping("/getAllMenuTree")
    public RespResult getAllMenuTree() {
        //从根目录开始查询，则得到的是全部的菜单tree
        logger.info("getAllMenuTree");
        int pid = -1;
        List<SysMenu> list = menuService.getMenusTreeByParentId(pid);
        return RespResult.success(list);
    }

    /**
     * 菜单管理---添加菜单。
     *
     * @return
     */
    @PostMapping("/addMenu")
    public RespResult addMenu(@RequestBody FullMenu menu) {
        int n = menuService.addMenu(menu);
        if (n == 1) {
            return RespResult.success("新增成功！");
        } else {
            return RespResult.fail("新增失败！");
        }
    }

    /**
     * 菜单管理---删除菜单
     *
     * @param map
     * @return
     */
    @PostMapping("/deleteMenuByMid")
    public RespResult deleteMenuByMid(@RequestBody Map<String, Object> map) {
        System.out.println("map:" + map);
        Integer id = (Integer) map.get("id");
        if (id == 1) {
            return RespResult.fail("根目录不允许被删除！");
        }
        //先查询此mid是否有子菜单，如果存在则不允许被删除
        List<SysMenu> list = menuService.getMenusTreeByParentId(id);
        if (list.isEmpty() || list.size() == 0) {
            int n = menuService.deleteMenuById(id);
            if (n == 1) {
                return RespResult.success("删除成功!");
            } else {
                return RespResult.fail("删除失败!");
            }
        } else {
            return RespResult.fail("该菜单下有子菜单，删除失败!");
        }
    }

    /**
     * 菜单管理---根据id查询菜单信息
     *
     * @return
     */
    @PostMapping("/selectMenuInfoByMid")
    public RespResult selectMenuInfoByMid(@RequestBody Map<String, Object> map) {
        System.out.println("map:" + map);
        Integer id = (Integer) map.get("id");
        FullMenu fullMenu = menuService.selectMenuInfoByMid(id);
        return RespResult.success(fullMenu);
    }

    /**
     * 菜单管理---修改菜单信息
     *
     * @return
     */
    @PostMapping("/editMenuInfoByMid")
    public RespResult editMenuInfoByMid(@RequestBody FullMenu menu) {
        //先根据id查询是否存在menu信息，如果不存在，则修改失败
        FullMenu fullMenu = menuService.selectMenuInfoByMid(menu.getId());
        if (fullMenu == null) {
            RespResult.fail("该菜单已经被删除，修改失败!");
        }
        int n = menuService.editMenuInfoByMid(menu);
        if (n == 1) {
            return RespResult.success("修改成功!");
        } else {
            return RespResult.fail("修改失败!");
        }
    }

}
