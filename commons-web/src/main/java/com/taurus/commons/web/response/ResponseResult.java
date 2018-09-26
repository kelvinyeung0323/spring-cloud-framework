package com.taurus.commons.web.response;

import java.io.Serializable;

/**
 * @author: Kelvin Yeung
 * @createdAt: 2018/9/26
 * @description: 响应结果实体
 */

public class ResponseResult implements Serializable{


    private static final long serialVersionUID = -1789153757289051793L;

    public static final String STATUS_SUCCESS = "ok";
    public static final String STATUS_FAIL = "fail";

    private String status;
    private String errorCode;
    private String message;
    private Object data;

    public ResponseResult() {
    }

    public ResponseResult(String status, String message) {
        this(status,message,null,null);
    }

    public ResponseResult(String status, String message, Object data) {
        this(status, message, data, null);
    }

    public ResponseResult(String status, String message, Object data, String errorCode) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.errorCode = errorCode;
    }

    public static ResponseResult success() {
        return new ResponseResult(STATUS_SUCCESS, "", null);
    }

    public static ResponseResult success(Object data) {
        return new ResponseResult(STATUS_SUCCESS, "", data,null);
    }

    public static ResponseResult success(Object data, String message) {
        return new ResponseResult(STATUS_SUCCESS, message, data,null);
    }



    public static ResponseResult fail() {
        return new ResponseResult(STATUS_FAIL, "", null,null);
    }

    public static ResponseResult fail(String errorCode) {
        return new ResponseResult(STATUS_FAIL, "", "",null);
    }

    public static ResponseResult fail(String errorCode, String message) {
        return new ResponseResult(STATUS_FAIL, message, "",null);
    }


    //----------------------------------------------
    //getter and setter

    public String getStatus() {
        return status;
    }

    public ResponseResult setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public ResponseResult setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseResult setData(Object data) {
        this.data = data;
        return this;
    }


    @Override
    public String toString() {
        return "ResponseResult{" +
                "status='" + status + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
