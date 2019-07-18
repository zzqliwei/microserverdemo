package com.westar.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 * hhttp://127.0.0.1:8300/turbine.stream
 */
@SpringBootApplication
@EnableEurekaClient //将项目标记为eurekaClient
@EnableTurbine
public class TurbineApp {
    public static void main( String[] args ){
        SpringApplication.run(TurbineApp.class,args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
