package com.taurus.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Kelvin Yeung on 2018/8/12.
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/user/{userName}")
    public String getUser(@PathVariable("userName") String userName){
        String result = restTemplate.getForObject("http://eureka-producer/user/"+userName,String.class);
        return  result;
    }
}
