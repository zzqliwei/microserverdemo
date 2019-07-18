package com.westar.conf;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FeignClient01Config {

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }
}
