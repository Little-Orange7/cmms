package com.myboot.cmms.controller.system.option;

import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.model.system.option.SysOption;
import com.myboot.cmms.model.system.select.SysSelect;
import com.myboot.cmms.service.system.option.OptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/option")
public class OptionController {
    private static final Logger logger = LoggerFactory.getLogger(OptionController.class);
    @Resource
    private OptionService optionService;

    /**
     * 根据selectCode查询Options
     *
     * @param select
     * @return
     */
    @PostMapping("/getOptionsBySelectCode")
    public RespResult getOptionsBySelectCode(@RequestBody SysSelect select) {
        logger.info("getOptionsBySelectCode======>select:" + select);
        String code = select.getSelectCode();
        List<SysOption> list = optionService.getOptionsBySelectCode(code);
        return RespResult.success(list);
    }

    /**
     * 增加Option
     *
     * @param option
     * @return
     */
    @PostMapping("/addOption")
    public RespResult addOption(@RequestBody SysOption option) {
        logger.info("addOption======>option:" + option);
        int n = optionService.addOption(option);
        if (n == 1) {
            return RespResult.success("新增成功!");
        }
        return RespResult.fail("新增失败!");
    }

    /**
     * 修改Option
     *
     * @param option
     * @return
     */
    @PostMapping("/editOption")
    public RespResult editOption(@RequestBody SysOption option) {
        logger.info("editOption======>option:" + option);
        int n = optionService.modifyOption(option);
        if (n == 1) {
            return RespResult.success("修改成功!");
        }
        return RespResult.fail("修改失败!");
    }

    /**
     * 删除Option
     * 根据OptionId删除id
     *
     * @param map
     * @return
     */
    @PostMapping("/delectOptionByOptionId")
    public RespResult delectOptionByOptionId(@RequestBody Map<String, Object> map) {
        logger.info("delectOptionByOptionId======>map:" + map);
        Integer id = (Integer) map.get("id");
        int n = optionService.deleteOptionByOptionId(id);
        if (n == 1) {
            return RespResult.success("修改成功!");
        }
        return RespResult.fail("修改失败!");
    }
}
