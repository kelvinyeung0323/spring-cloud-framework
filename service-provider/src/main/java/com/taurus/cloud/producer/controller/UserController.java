package com.taurus.cloud.producer.controller;

import com.taurus.cloud.producer.entity.User;
import com.taurus.cloud.producer.vo.UserVO;
import com.taurus.commons.web.exception.ServiceException;
import com.taurus.commons.web.request.PaginationRequest;
import com.taurus.commons.web.response.ErrorCode;
import com.taurus.commons.web.response.PaginationResult;
import com.taurus.commons.web.response.ResponseResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Kelvin Yeung on 2018/8/12.
 */
@Api(value = "UserController"
        , tags = {"用户接口"}
        , description = "用户接口，用户数据的请求"
//        , produces = "application/json;charset=UTF-8"
//        , consumes = "application/json;charset=UTF-8"
        , protocols = "http"
//        , basePath = "/api", hidden = true
//        , authorizations = {@Authorization("kelvin")}
        )
@RestController
public class UserController {



    @ApiOperation(value = "获取用户", notes = "获取所有用户信息", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页面大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "sort", value = "排序", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userName", value = "用户名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String")
    })
    @GetMapping("/users")
    //注意，这里参数对象不加@RequestBody注解，如果是post请求把json对像post过来则需要@RequestBody注解，如果是get方法把成员属性附加在url上，则不加@RquestBody
    public PaginationResult users(UserVO userVO, PaginationRequest pagination){
        return new PaginationResult().page(100L,20,3,new ArrayList());
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String userName){
        User user = new User();
        user.setUserName(userName);
        user.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        user.setPassowrd("password");
        return user;
    }


    @GetMapping("/user/exception")
    public ResponseResult exception(){
        throw new ServiceException("service exception", ErrorCode.UNKOWN_ERROR);
    }
}
