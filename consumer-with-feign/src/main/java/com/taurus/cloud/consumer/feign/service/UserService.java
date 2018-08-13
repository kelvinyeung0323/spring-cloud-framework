package com.taurus.cloud.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Kelvin Yeung on 2018/8/12.
 */
@FeignClient("eureka-producer")
public interface UserService {
    @RequestMapping(method = RequestMethod.GET,value = "/user/{userName}")
    String getUser(@PathVariable("userName") String userName);
}
