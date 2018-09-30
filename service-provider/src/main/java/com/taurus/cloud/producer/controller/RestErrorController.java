package com.taurus.cloud.producer.controller;

import com.taurus.commons.web.exception.ServiceException;
import com.taurus.commons.web.response.ErrorCode;
import com.taurus.commons.web.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Kelvin Yeung
 * @createdAt: 2018/9/27
 * @description: 统一异常处理
 */
@RestController
@EnableConfigurationProperties({ServerProperties.class})
public class RestErrorController implements ErrorController {


    private ErrorAttributes errorAttributes;
    @Autowired
    private ServerProperties serverProperties;

    /**
     * 初始化ExceptionController
     * @param errorAttributes
     */
    @Autowired
    public RestErrorController(ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = "/error")
    @ResponseBody
    public ResponseResult error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
//        HttpStatus status = getStatus(request);
        return ResponseResult.fail(body.get("status").toString(), body.get("message").toString());
    }

    /**
     * Determine if the stacktrace attribute should be included.
     *
     * @param request  the source request
     * @param produces the media type produced (or {@code MediaType.ALL})
     * @return if the stacktrace attribute should be included
     */
    protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
        ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true;
        }
        if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
            return getTraceParameter(request);
        }
        return false;
    }

    /**
     * 获取错误的信息
     *
     * @param request
     * @param includeStackTrace
     * @return
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {

        WebRequest webRequest = new ServletWebRequest(request);
        Throwable e = errorAttributes.getError(webRequest);
        if (e instanceof ServiceException) {
            Map<String, Object> map = new HashMap<>();
            ErrorCode errorCode = ((ServiceException) e).getErrorCode();
            String message = e.getMessage();
            if (null == message || message.isEmpty()) {
                message = errorCode.getMsg();
            }
            if(includeStackTrace){
                message +="\n" +e.getStackTrace().toString();
            }
            map.put("status", errorCode.getCode());
            map.put("message", message);
            return map;
        }
        return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
    }

    /**
     * 是否包含trace
     *
     * @param request
     * @return
     */
    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

//    /**
//     * 获取错误编码
//     *
//     * @param request
//     * @return
//     */
//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if (statusCode == null) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        try {
//            return HttpStatus.valueOf(statusCode);
//        } catch (Exception ex) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//    }

    @Override
    public String getErrorPath() {
        return "";
    }


}
