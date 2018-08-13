package com.taurus.cloud.producer;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Kelvin Yeung on 2018/8/12.
 */
@SpringBootApplication
@EnableEurekaClient
public class ProducerApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ProducerApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
