package com.zi.sys.result;

/**
 * Created by 汪梓文 on 2016/8/17.
 */

import com.google.gson.Gson;

/**
 * 对外统一返回结果
 */
public class Result {
    private boolean success = true;
    private Object data;
    private String errMsg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }


}
