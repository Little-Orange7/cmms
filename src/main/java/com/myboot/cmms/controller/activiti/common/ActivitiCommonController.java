package com.myboot.cmms.controller.activiti.common;


import com.myboot.cmms.model.activiti.common.Deployment;
import com.myboot.cmms.model.system.common.RespResult;
import com.myboot.cmms.service.activiti.common.ActivitiCommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/activiti")
public class ActivitiCommonController {
    private static final Logger logger = LoggerFactory.getLogger(ActivitiCommonController.class);
    @Resource
    private ActivitiCommonService activitiCommonService;

    /**
     * 部署流程
     *
     * @return
     */
    @PostMapping("/createDeployment")
    public RespResult createDeployment(@RequestBody Deployment deployment) {
        logger.info("deployment:[{}]", deployment);
        //注意：使用xml方式部署，传入的name必须是带后缀(.bpmn),否则部署流程act_re_procdef表没有数据；
        boolean ret=activitiCommonService.createDeploymentByXml(deployment.getName()+".bpmn",deployment.getResource());
        if(!ret){
            return RespResult.fail("部署失败!");
        }
        return RespResult.success("部署成功！");
    }


    /**
     * 发起流程(启动流程) 如果没有部署，则会报异常
     * http://127.0.0.1:8088/activiti/startActivityDemo?key=myProcess_1
     *http://127.0.0.1:8088/activiti/startActivityDemo?key=myProcess_1
     * @return
     */
    @GetMapping("/startActivityDemo")
    public Boolean startActivityDemo(String key) {
        System.out.println("key:" + key);
        return activitiCommonService.startActivityDemo(key);//"myProcess_1"
    }

    /**
     * 查询所有已部署的流程
     * http://127.0.0.1:8088/activiti/queryProcdef
     *
     * @return
     */
    @RequestMapping("/queryProcdef")
    public Boolean queryProcdef() {
        return activitiCommonService.queryProcdef();
    }


    /**
     * 获取待办，根据用户获取该用户的代办任务
     * http://127.0.0.1:8088/activiti/getTaskList?assignee=user1
     *
     * @return
     */
    @GetMapping("/getTaskList")
    public boolean getTaskList(String assignee) {
        System.out.println(assignee);
        return activitiCommonService.getTaskList(assignee);
    }

    /**
     * 提交，流程图中有判断条件，添加判断参数
     * http://127.0.0.1:8088/activiti/complete?taskId=51c98606-9690-11ea-8e3d-90784129e942&message=Y
     *
     * @param taskId
     * @return
     */
    @GetMapping("/complete")
    public boolean complete(String taskId, String message) {
        System.out.println("taskId:" + taskId + ",message:" + message);
        return activitiCommonService.complete(taskId, message);
    }

    /**
     * 根据流程id直接结束流程
     * http://127.0.0.1:8088/activiti/deleteProcessInstance?runId=myProcess_1
     *
     * @return
     * @paramru
     */
    @GetMapping("/deleteProcessInstance")
    public boolean deleteProcessInstance(String runId) {
        System.out.println("runId:" + runId);
        return activitiCommonService.deleteProcessInstance(runId);
    }

}
