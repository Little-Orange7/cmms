package com.myboot.cmms.model.system.menu;

import java.io.Serializable;

public class Meta implements Serializable {
    private String iconCls;

    private String title;

    private Boolean keepAlive;

    private Boolean requireAuth;

    private static final long serialVersionUID = 1L;

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Meta{");
        sb.append("iconCls='").append(iconCls).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", keepAlive=").append(keepAlive);
        sb.append(", requireAuth=").append(requireAuth);
        sb.append('}');
        return sb.toString();
    }
}
