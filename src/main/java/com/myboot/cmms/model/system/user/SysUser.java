package com.myboot.cmms.model.system.user;

import java.io.Serializable;

public class SysUser implements Serializable {
    private Integer id;

    private String loginName;

    private String loginPwd;

    private String userName;

    private String userFace;

    private String userGender;

    private String mobilePhone;

    private String userMail;

    private String userRemark;

    private String userStatus;

    private String certNo;

    private String orgCode;

    private String userAddress;

    private String userPosition;

    private String firstLoginTime;

    private String lastLoginTime;

    private String lastLogoutTime;

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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace == null ? null : userFace.trim();
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark == null ? null : userRemark.trim();
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition == null ? null : userPosition.trim();
    }

    public String getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(String firstLoginTime) {
        this.firstLoginTime = firstLoginTime == null ? null : firstLoginTime.trim();
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime == null ? null : lastLoginTime.trim();
    }

    public String getLastLogoutTime() {
        return lastLogoutTime;
    }

    public void setLastLogoutTime(String lastLogoutTime) {
        this.lastLogoutTime = lastLogoutTime == null ? null : lastLogoutTime.trim();
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
        final StringBuffer sb = new StringBuffer("SysUser{");
        sb.append("id=").append(id);
        sb.append(", loginName='").append(loginName).append('\'');
        sb.append(", loginPwd='").append(loginPwd).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", userFace='").append(userFace).append('\'');
        sb.append(", userGender='").append(userGender).append('\'');
        sb.append(", mobilePhone='").append(mobilePhone).append('\'');
        sb.append(", userMail='").append(userMail).append('\'');
        sb.append(", userRemark='").append(userRemark).append('\'');
        sb.append(", userStatus='").append(userStatus).append('\'');
        sb.append(", certNo='").append(certNo).append('\'');
        sb.append(", orgCode='").append(orgCode).append('\'');
        sb.append(", userAddress='").append(userAddress).append('\'');
        sb.append(", userPosition='").append(userPosition).append('\'');
        sb.append(", firstLoginTime='").append(firstLoginTime).append('\'');
        sb.append(", lastLoginTime='").append(lastLoginTime).append('\'');
        sb.append(", lastLogoutTime='").append(lastLogoutTime).append('\'');
        sb.append(", createUser='").append(createUser).append('\'');
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append(", updateUser='").append(updateUser).append('\'');
        sb.append(", updateTime='").append(updateTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
