package com.taurus.commons.web.response;

/**
 * @author: Kelvin Yeung
 * @createdAt: 2018/9/26
 * @description:
 */
public enum ErrorCode {

    //概据需要添加
    UNKOWN_ERROR(2001, "未知错误"),
    NOT_FOUND(404, "Not Found");

    int code;
    String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
