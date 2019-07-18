package com.westar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer //将项目标记为eurekaServer
public class EurekaAppHa {
    public static void main( String[] args ) {
        SpringApplication.run(EurekaApp.class,args);
    }
}
