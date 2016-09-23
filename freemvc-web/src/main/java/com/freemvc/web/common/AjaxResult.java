package com.freemvc.web.common;

/**
 * Created by yangliangbin on 2016/9/26.
 * jax请求结果
 */

public class AjaxResult {

    private boolean isOk = true;
    private String msg = "操作成功";
    private Object data;

    public boolean getIsOk() {
        return isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
