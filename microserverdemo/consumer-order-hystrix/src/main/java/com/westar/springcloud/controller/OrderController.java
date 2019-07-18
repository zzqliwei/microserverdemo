package com.westar.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.westar.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;

//    private String url = "http://127.0.0.1:7900/user/";

//    @Value("${user.url}")
//    private String url;

    @GetMapping("/order/{id}")
    @HystrixCommand(fallbackMethod = "shibai" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE")
    })//execution.isolation.strategy 默认就好，若果遇到了再修改
    public User getOrder(@PathVariable("id") Long id){

        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("PROVIDER-USER",false);
        String url = instanceInfo.getHomePageUrl();
        //访问提供者回去数据
        User user = restTemplate.getForObject(url+"user/"+id,User.class);
        return user;
    }
    public User shibai(Long id){
        User user = new User(-100L);
        return user;
    }
}
