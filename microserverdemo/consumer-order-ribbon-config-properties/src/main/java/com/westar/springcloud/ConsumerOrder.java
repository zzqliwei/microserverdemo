package com.westar.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient //将项目标记为eurekaClient
@RibbonClient(name = "PROVIDER-USER",configuration = TestConfig.class) //启用Ribbon，对PROVIDER-USER做负载均衡
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value = ExcludeCommentScan.class )} )
public class ConsumerOrder {
    public static void main( String[] args ){
        SpringApplication.run(ConsumerOrder.class,args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
