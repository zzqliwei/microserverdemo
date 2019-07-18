package com.westar.springcloud.controller;

import com.westar.springcloud.feign.FeignClient01;
import com.westar.springcloud.feign.FeignClient02;
import com.westar.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    FeignClient01 feignClient01;

    @Autowired
    FeignClient02 feignClient02;

    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable("id") Long id){
        //访问提供者回去数据
        User user = feignClient01.getOrder(id);
        return user;
    }

    @GetMapping("/get_user")
    public User get_User(User user){
        User user01 = feignClient01.get_User(user);
        return user01;
    }

    @GetMapping("/getServiceInfo/{serviceName}")
    public String getServiceInfo(@PathVariable("serviceName") String serviceName){
        String info = feignClient02.getServiceInfo(serviceName);
        return info;
    }
}
