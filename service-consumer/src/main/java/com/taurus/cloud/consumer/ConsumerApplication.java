package com.taurus.cloud.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Kelvin Yeung on 2018/5/7.
 */
@SpringBootApplication
@RestController
public class ConsumerApplication {

//    @Value("${info.foo}")
//    private String foo;
    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

//    @RequestMapping("test")
//    public String test(){
//        return foo;
//    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate;
    }

    public static void main(String[] args){
       new  SpringApplicationBuilder(ConsumerApplication.class).web(WebApplicationType.SERVLET).run(args);
    }



}
