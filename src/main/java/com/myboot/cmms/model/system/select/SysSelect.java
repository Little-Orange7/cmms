package com.myboot.cmms.model.system.select;

import com.myboot.cmms.model.system.common.base.SysBase;

import java.io.Serializable;

public class SysSelect extends SysBase implements Serializable {
    private Integer id;

    private String selectCode;

    private String selectName;

    private String selectRemark;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSelectCode() {
        return selectCode;
    }

    public void setSelectCode(String selectCode) {
        this.selectCode = selectCode == null ? null : selectCode.trim();
    }

    public String getSelectName() {
        return selectName;
    }

    public void setSelectName(String selectName) {
        this.selectName = selectName == null ? null : selectName.trim();
    }

    public String getSelectRemark() {
        return selectRemark;
    }

    public void setSelectRemark(String selectRemark) {
        this.selectRemark = selectRemark == null ? null : selectRemark.trim();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SysSelect{");
        sb.append("id=").append(id);
        sb.append(", selectCode='").append(selectCode).append('\'');
        sb.append(", selectName='").append(selectName).append('\'');
        sb.append(", selectRemark='").append(selectRemark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
