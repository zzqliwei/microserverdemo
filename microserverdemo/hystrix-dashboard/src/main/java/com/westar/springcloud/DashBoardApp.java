package com.westar.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * http://192.168.1.55:9900/hystrix
 * 监控 http://192.168.1.55:8900/hystrix.stream
 *      http://192.168.1.55:8900/turbine.stream
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoardApp {
    public static void main(String[] args) {
        SpringApplication.run(DashBoardApp.class,args);
    }
}
