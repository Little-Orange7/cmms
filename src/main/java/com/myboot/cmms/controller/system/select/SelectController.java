package com.myboot.cmms.controller.system.select;

import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.model.system.option.SysOption;
import com.myboot.cmms.model.system.select.SysSelect;
import com.myboot.cmms.service.system.option.OptionService;
import com.myboot.cmms.service.system.select.SelectService;
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
@RequestMapping("/system/select")
public class SelectController {
    private static final Logger logger = LoggerFactory.getLogger(SelectController.class);
    @Resource
    private SelectService selectService;
    @Resource
    private OptionService optionService;

    /**
     * 根据select对象查询条件模糊查询select列表
     * @param select
     * @return
     */
    @PostMapping("/getSelectListByCondition")
    public RespResult getSelectListByCondition(@RequestBody SysSelect select){
        logger.info("getSelectListByCondition======>select:"+select);
        List<SysSelect> list=selectService.getSelectListByCondition(select);
        return RespResult.success(list);
    }

    /**
     * 新增select
     * 新增之前，要先判断是否已经存在selectCode,如果存在则不能新增
     * @param select
     * @return
     */
    @PostMapping("/addSelect")
    public RespResult addSelect(@RequestBody SysSelect select){
        logger.info("addSelect======>select:"+select);
        SysSelect sysSelect=selectService.selectBySelectCode(select.getSelectCode());
        if(sysSelect!=null){
            return RespResult.fail("选择码已经存在!");
        }
        int n=selectService.addSelect(select);
        if(n==1){
            return RespResult.success("新增成功!");
        }
        return RespResult.fail("新增失败!");
    }

    /**
     * 修改select
     * 要先判断selectCode是否重复
     * @param select
     * @return
     */
    @PostMapping("/editSelect")
    public RespResult editSelect(@RequestBody SysSelect select){
        logger.info("editSelect======>select:"+select);
        int n=selectService.modifySelectById(select);
        if(n==1){
            return RespResult.success("修改成功!");
        }
        return RespResult.fail("修改失败!");
    }

    /**
     * 删除select
     * 根据id删除select
     * 先查询是否存在Option，如果有则，需要先删除Option
     * @param map
     * @return
     */
    @PostMapping("/deleteSelectById")
    public RespResult deleteSelectById(@RequestBody Map<String,Object> map){
        logger.info("deleteSelectById======>map:"+map);
        Integer id=(Integer)map.get("id");
        List<SysOption> list=optionService.getOptionsBySelectId(id);
        logger.info("deleteSelectById======>list:"+list);
        if(list!=null&&!list.isEmpty()){
            return RespResult.fail("其下存在Option,请先删除Option!");
        }
        int n=selectService.deleteSelectById(id);
        if(n==1){
            return RespResult.success("删除成功!");
        }
        return RespResult.fail("删除失败!");
    }

}
