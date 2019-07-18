package com.westar.conf;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class FeignClient02Config {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","123");
    }
    //配置打印日志内容必须在debug模式下
    @Bean
    Logger.Level geignloggerLever(){
        return Logger.Level.FULL;
    }


//    @Bean //用于停用Feign与Hystrix
//    @Scope("PROTOTYPE")
//    public Feign.Builder feignBuilder(){
//        return new Feign.Builder();
//    }

}
