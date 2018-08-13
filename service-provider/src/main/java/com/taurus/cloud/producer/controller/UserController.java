package com.taurus.cloud.producer.controller;

import com.taurus.cloud.producer.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Kelvin Yeung on 2018/8/12.
 */
@RestController
public class UserController {


    @RequestMapping("/user/{userName}")
    public User getUser(@PathVariable("userName") String userName){
        User user = new User();
        user.setUserName(userName);
        user.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        user.setPassowrd("password");
        return user;
    }



}
