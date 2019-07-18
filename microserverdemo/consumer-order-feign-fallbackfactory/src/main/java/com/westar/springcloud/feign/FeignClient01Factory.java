package com.westar.springcloud.feign;

import com.westar.springcloud.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClient01Factory implements FallbackFactory<FeignClient01> {
    @Override
    public FeignClient01 create(Throwable throwable) {
        return new FeignClient01() {
            @Override
            public User getOrder(Long id) {
                User user = new User(-500L);
                return user;
            }

            @Override
            public User get_User(User user) {
                return user;
            }
        };
    }
}
