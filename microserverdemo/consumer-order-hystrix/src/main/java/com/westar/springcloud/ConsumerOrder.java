package com.westar.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 * http://127.0.0.1:8900/hystrix.stream
 */
@SpringBootApplication
@EnableEurekaClient //将项目标记为eurekaClient
@EnableCircuitBreaker
public class ConsumerOrder {
    public static void main( String[] args ){
        SpringApplication.run(ConsumerOrder.class,args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
