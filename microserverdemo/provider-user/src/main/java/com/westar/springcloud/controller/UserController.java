package com.westar.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.westar.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){
        return new User(id);
    }

    @GetMapping("/eurakeInfo")
    public String info(){
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("PROVIDER-USER",false);
        return instanceInfo.getHomePageUrl();
    }
    @PostMapping("/get_user")
    public User getUser(@RequestBody User user){
        return user;
    }
}
