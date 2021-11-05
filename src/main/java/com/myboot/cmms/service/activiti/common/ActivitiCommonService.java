package com.myboot.cmms.service.activiti.common;

public interface ActivitiCommonService {
    boolean createDeploymentByClassPath(String resource);

    boolean createDeploymentByXml(String name,String resource);

    boolean createDeploymentByInputStream(String resource);

    boolean createDeploymentByZipOrBar(String resource);

    boolean queryProcdef();

    boolean startActivityDemo(String key);

    boolean getTaskList(String assignee);

    boolean complete(String taskId, String message);

    boolean deleteProcessInstance(String runId);
}
