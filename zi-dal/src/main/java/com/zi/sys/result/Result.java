package com.zi.sys.result;

/**
 * Created by 汪梓文 on 2016/8/17.
 */

import com.google.gson.Gson;
import com.zi.sys.constant.StateCodeConstant;

/**
 * 对外统一返回结果
 */
public class Result {
    private boolean success = true;
    private Object data;
    private String errMsg;
    private String message;
    private int code = StateCodeConstant.STATE_200.getCode();

    public Result() {
    }

    public Result(boolean success, Object data, String msg) {
        this.success = success;
        this.data = data;
        this.message = msg;
    }

    public Result(boolean success, String msg) {
        this.success = success;
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

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
