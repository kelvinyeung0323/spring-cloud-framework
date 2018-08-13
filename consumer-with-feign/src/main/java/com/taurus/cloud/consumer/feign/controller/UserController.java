package com.taurus.cloud.consumer.feign.controller;

import com.taurus.cloud.consumer.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kelvin Yeung on 2018/8/12.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{userName}")
    public String getUser(@PathVariable("userName") String userName){

        return userService.getUser(userName);
    }
}
