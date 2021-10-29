package com.myboot.cmms.model.system.common;

import java.io.Serializable;

public class RespResult implements Serializable {
    private Integer code;//200:表示处理成功，非200表示
    private String msg;
    private Object obj;

    private RespResult(Integer code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.obj = object;
    }

    //处理成功，只返回成功的消息
    public static RespResult success(String msg) {
        return new RespResult(200, msg, null);
    }

    //处理成功，只返回成功的数据
    public static RespResult success(Object object) {
        return new RespResult(200, null, object);
    }

    //处理成功，返回成功消息和数据
    public static RespResult success(String msg, Object object) {
        return new RespResult(200, msg, object);
    }

    //处理失败，返回错误消息
    public static RespResult fail(String msg) {
        return new RespResult(500, msg, null);
    }

    //退出登录，则返回402
    public static RespResult logout(String msg) {
        return new RespResult(402, msg, null);
    }

    //必须添加getter、setter方法，否则会报错不能转换
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
