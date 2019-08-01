package com.westar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world! 可以在zuul上指定附件上传超时时间
 *
 */
@SpringBootApplication
@EnableEurekaClient //将项目标记为eurekaServer
public class FileUploadApp {
    public static void main( String[] args ) {
        SpringApplication.run(FileUploadApp.class,args);
    }
}
