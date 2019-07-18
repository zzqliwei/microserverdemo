package com.westar.springcloud.feign;

import com.westar.springcloud.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class FeignClient01Hystrix implements FeignClient01{
    @Override
    public User getOrder(Long id) {
        User user = new User(-300L);
        return user;
    }

    @Override
    public User get_User(User user) {
        return null;
    }
}
