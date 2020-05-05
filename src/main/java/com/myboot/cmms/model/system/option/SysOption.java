package com.myboot.cmms.model.system.option;

import java.io.Serializable;

public class SysOption implements Serializable {
    private Integer id;

    private Integer selectId;

    private String optionValue;

    private String optionLabel;

    private Integer optionKey;

    private String optionRemark;

    private String createUser;

    private String createTime;

    private String updateUser;

    private String updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue == null ? null : optionValue.trim();
    }

    public String getOptionLabel() {
        return optionLabel;
    }

    public void setOptionLabel(String optionLabel) {
        this.optionLabel = optionLabel == null ? null : optionLabel.trim();
    }

    public Integer getOptionKey() {
        return optionKey;
    }

    public void setOptionKey(Integer optionKey) {
        this.optionKey = optionKey;
    }

    public String getOptionRemark() {
        return optionRemark;
    }

    public void setOptionRemark(String optionRemark) {
        this.optionRemark = optionRemark == null ? null : optionRemark.trim();
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
        final StringBuffer sb = new StringBuffer("SysOption{");
        sb.append("id=").append(id);
        sb.append(", selectId=").append(selectId);
        sb.append(", optionValue='").append(optionValue).append('\'');
        sb.append(", optionLabel='").append(optionLabel).append('\'');
        sb.append(", optionKey=").append(optionKey);
        sb.append(", optionRemark='").append(optionRemark).append('\'');
        sb.append(", createUser='").append(createUser).append('\'');
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append(", updateUser='").append(updateUser).append('\'');
        sb.append(", updateTime='").append(updateTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
