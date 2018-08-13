package com.taurus.cloud.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Kelvin Yeung on 2018/8/12.
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class FeignApplication {



    public static void main(String[] args){
        new SpringApplicationBuilder(FeignApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
