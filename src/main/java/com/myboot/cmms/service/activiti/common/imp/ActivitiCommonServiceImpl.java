package com.myboot.cmms.service.activiti.common.imp;


import com.myboot.cmms.service.activiti.common.ActivitiCommonService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

@Service
public class ActivitiCommonServiceImpl implements ActivitiCommonService {
    @Resource
    private RepositoryService repositoryService;
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private TaskService taskService;


    /**
     * 部署一个流程(classpath方式)
     * (流程图修改之后，需要重新部署该流程)
     * @param name 资源名称（默认位置在resource下）
     * @return
     */
    @Override
    public boolean createDeploymentByClassPath(String name) {
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addClasspathResource(name);//"test01.bpmn"
        builder.deploy();
        return true;
    }

    /**
     * 部署一个流程（xml方式）
     * (流程图修改之后，需要重新部署该流程)
     * @param name 流程的名称
     * @param xmlStr xml字符串
     * @return
     */
    @Override
    public boolean createDeploymentByXml(String name,String xmlStr) {
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addString(name,xmlStr);
        builder.deploy();
        return true;
    }

    /**
     * 部署一个流程(InputStream方式)
     * 流程图修改之后，需要重新部署该流程
     * @param resource 资源路径及名称
     * @return
     */
    @Override
    public boolean createDeploymentByInputStream(String resource) {
        //获取资源相对路径
//        String resource = "diagrams/helloworld.bpmn";
        String pngPath = "diagrams/helloworld.png";

        //读取资源作为一个输入流
        FileInputStream bpmnfileInputStream = null;
//        FileInputStream pngfileInputStream = null;
        try{
            bpmnfileInputStream = new FileInputStream(resource);
//            pngfileInputStream = new FileInputStream(pngPath);
            DeploymentBuilder builder = repositoryService.createDeployment();
            builder.addInputStream("helloworld.bpmn",bpmnfileInputStream);//
//        builder.addInputStream("helloworld.png",pngfileInputStream);//一次部署两个流程
            builder.deploy();
        }catch (FileNotFoundException e){
            return false;
        }finally {
            try{
                if(null!=bpmnfileInputStream){
                    bpmnfileInputStream.close();
                }
            }catch (Exception e){
            }
        }
        return true;
    }

    /**
     * 部署一个流程(Zip/Bar方式)
     *  打包文件扩展名可以是Activiti官方推荐的bar或普通的zip，可以一次部署多个流程
     *  (流程图修改之后，需要重新部署该流程)
     * @param resource 资源路径及名称
     * @return
     */
    @Override
    public boolean createDeploymentByZipOrBar(String resource) {
        //从classpath路径下读取资源文件（将helloworld.bpmn和helloworld.png压缩成zip格式的文件）
//        String resource="diagrams/helloworld.zip";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(resource);
        ZipInputStream zipInputStream = new ZipInputStream(in);
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addZipInputStream(zipInputStream);//"test01.bpmn"
        builder.deploy();
        return true;
    }

    /**
     * 查询部署的流程
     *
     * @return
     */
    public boolean queryProcdef() {
        //创建查询对象
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        //添加查询条件
        //query.processDefinitionKey("myProcess_2");//通过key获取
        //query.processDefinitionName("My process")//通过name获取
        query.orderByProcessDefinitionId().asc();//根据ID排序
        //执行查询获取流程定义
        List<ProcessDefinition> pds = query.list();
        for (ProcessDefinition pd : pds) {
            System.out.println("id:" + pd.getId() + ",name:" + pd.getName() + ",key:" + pd.getKey() + ",version:" + pd.getVersion() + ",resourceName:" + pd.getResourceName() + ",diagramResourceName:" + pd.getDiagramResourceName());
        }
        return true;
    }

    /**
     * 查询待办
     *
     * @return
     */
    public boolean getTaskList(String assignee) {
//        List<Task> tasks = taskService.createTaskQuery().list();//查询所有经办人的所有待办
        //根据用户获取该用户的待办信息
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();
        for (Task t : tasks) {
            System.out.println("taskId:" + t.getId() + ",assignee:" + t.getAssignee() + ",name:" + t.getName() + ",processInstanceId:" + t.getProcessInstanceId() + ",taskDefinitionKey:" + t.getTaskDefinitionKey() + ",message:" + taskService.getVariable(t.getId(), "message"));
        }
        return true;
    }


    /**
     * 根据流程key开启一个流程
     *
     * @param key
     * @return
     */
    @Override
    public boolean startActivityDemo(String key) {
        /**
         * 一般业务数据的主键放到这个流程实例的bussinessKey中，
         * 如果需要查询业务数据，可以根据这个业务主键来查询业务表，从而获取业务数据。
         */
        String bussinessKey = "123456";//业务主键
        ProcessInstance test01 = runtimeService.startProcessInstanceByKey(key, bussinessKey);
//        ProcessInstance test01 = runtimeService.startProcessInstanceByKey(key);
        String id = test01.getId();
        System.out.println("流程id=" + id);
        System.out.println("流程定义id:" + test01.getProcessDefinitionId());//输出流程定义的id
        return true;
    }

    /**
     * 根据任务id提交任务
     *
     * @param taskId
     * @return
     */
    @Override
    public boolean complete(String taskId, String message) {
        /**
         * 这里taskService.complete(taskId,variables)的variables变量一般用于流程图节点判断的条件变量，比如该
         * 处审批通过，则可以将“同意”的值放入variables，那么提交之后，后面节点的判断就可以拿到这个variables的值
         * 来判断，从而可以决定下一步流程的走向；一般业务数据不放到这个变量里，都是在流程实例的bussinessKey中存放
         * 业务表主键，如果需要查询业务数据，可以根据这个业务主键来查询业务表，从而获取业务数据。
         */

        //完成任务的同时，设置流程变量，让流程变量判断连线该如何执行
        /**
         * 设置参数的方式一
         * 注意setVariableLocal与setVariable的区别
         */
        taskService.setVariableLocal(taskId, "message", message); // 与任务ID绑定
//        taskService.setVariable(taskId, "message", message);
        taskService.complete(taskId);

        /**
         * 设置参数的方式二
         * 注意这种方式设置的参数，在整个流程中，值不能被覆盖，即第一次被赋值之后，后面就不能被改变。
         */
        /*Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("message", message);
        taskService.complete(taskId,variables);*/
        return true;
    }

    /**
     * 根据流程id直接结束流程
     *
     * @param runId
     * @return
     */
    @Override
    public boolean deleteProcessInstance(String runId) {
        runtimeService.deleteProcessInstance(runId, "结束");
        return true;
    }

    public boolean setAssignee() {
        String taskId = "";
        String userId = "";
        taskService.setAssignee(taskId, userId);//授权审批人
        return true;
    }
}
