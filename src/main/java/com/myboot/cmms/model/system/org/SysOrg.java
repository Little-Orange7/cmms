package com.myboot.cmms.model.system.org;

import java.io.Serializable;
import java.util.List;

public class SysOrg implements Serializable {
    private Integer id;

    private String orgName;

    private String orgCode;

    private Integer parentId;

    private Boolean orgStatus;

    private String orgPrincipal;

    private String orgPhone;

    private String orgAddress;

    private String orgRemark;

    private List<SysOrg> children;

    private String createUser;

    private String createTime;

    private String updateUser;

    private String updateTime;

    private static final long serialVersionUID = 1L;

    public List<SysOrg> getChildren() {
        return children;
    }

    public void setChildren(List<SysOrg> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(Boolean orgStatus) {
        this.orgStatus = orgStatus;
    }

    public String getOrgPrincipal() {
        return orgPrincipal;
    }

    public void setOrgPrincipal(String orgPrincipal) {
        this.orgPrincipal = orgPrincipal == null ? null : orgPrincipal.trim();
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone == null ? null : orgPhone.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    public String getOrgRemark() {
        return orgRemark;
    }

    public void setOrgRemark(String orgRemark) {
        this.orgRemark = orgRemark == null ? null : orgRemark.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SysOrg{");
        sb.append("id=").append(id);
        sb.append(", orgName='").append(orgName).append('\'');
        sb.append(", orgCode='").append(orgCode).append('\'');
        sb.append(", parentId=").append(parentId);
        sb.append(", orgStatus=").append(orgStatus);
        sb.append(", orgPrincipal='").append(orgPrincipal).append('\'');
        sb.append(", orgPhone='").append(orgPhone).append('\'');
        sb.append(", orgAddress='").append(orgAddress).append('\'');
        sb.append(", orgRemark='").append(orgRemark).append('\'');
        sb.append(", children=").append(children);
        sb.append(", createUser='").append(createUser).append('\'');
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append(", updateUser='").append(updateUser).append('\'');
        sb.append(", updateTime='").append(updateTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
