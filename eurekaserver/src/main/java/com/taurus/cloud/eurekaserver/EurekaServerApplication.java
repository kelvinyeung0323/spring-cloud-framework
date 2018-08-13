package com.taurus.cloud.eurekaserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Kelvin Yeung on 2018/5/5.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args){

//        SpringApplication.run(EurekaServerApplication.class,args);
        new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }
}
