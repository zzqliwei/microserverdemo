package com.westar.springcloud.feign;

import com.westar.conf.FeignClient01Config;
import com.westar.springcloud.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "provider-user",configuration = FeignClient01Config.class)
public interface FeignClient01 {
//    @GetMapping("/user/{id}")
    @RequestLine("GET /user/{id}") //组合注解
    public User getOrder(@Param("id")  Long id);

//    @PostMapping("/get_user")
    @RequestLine("POST /get_user") //组合注解
    User get_User(@RequestBody User user);
}
