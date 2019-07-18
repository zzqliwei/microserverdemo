package com.westar.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient //将项目标记为eurekaClient
@EnableFeignClients
public class ConsumerOrder {
    public static void main( String[] args ){
        SpringApplication.run(ConsumerOrder.class,args);
    }
}
