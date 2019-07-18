package com.westar.springcloud.feign;

import com.westar.springcloud.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "provider-user",fallbackFactory = FeignClient01Factory.class)
public interface FeignClient01 {
    @GetMapping("/user/{id}")
    public User getOrder(@PathVariable("id")  Long id);

    @PostMapping("/get_user")
    User get_User(User user);
}
