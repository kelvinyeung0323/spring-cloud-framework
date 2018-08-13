package com.taurus.cloud.consumer.feign;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Kelvin Yeung on 2018/8/12.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//开启断路器
@EnableCircuitBreaker
//@EnableHystrix
@EnableHystrixDashboard
public class FeignHystrixApplication {

    public static void main(String[] args){
        new SpringApplicationBuilder(FeignHystrixApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
