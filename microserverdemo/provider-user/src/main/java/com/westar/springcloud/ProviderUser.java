package com.westar.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient //将项目标记为eurekaClient
public class ProviderUser {
    public static void main( String[] args ){
        SpringApplication.run(ProviderUser.class,args);
    }
}
