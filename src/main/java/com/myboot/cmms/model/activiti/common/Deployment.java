package com.myboot.cmms.model.activiti.common;

import java.io.Serializable;

public class Deployment implements Serializable {

    //部署方式
    private String type;

    //流程名称
    private String name;

    //资源
    private String resource;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Deployment{");
        sb.append("type='").append(type).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", resource='").append(resource).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
