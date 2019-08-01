package com.westar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * http://127.0.0.1:10900/provider-user/user/1
 */
@SpringBootApplication
@EnableSidecar
public class SiderCarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SiderCarApplication.class, args);
    }
}
