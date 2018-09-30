package com.taurus.commons.web.exception;

import com.taurus.commons.web.response.ErrorCode;

/**
 * @author: Kelvin Yeung
 * @createdAt: 2018/9/26
 * @description:
 */
public class ServiceException extends RuntimeException {

    private ErrorCode errorCode;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message,ErrorCode errorCode) {
        super(message);
        if(null== errorCode){
            this.errorCode = ErrorCode.UNKOWN_ERROR;
        }else{
            this.errorCode = errorCode;
        }

    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
