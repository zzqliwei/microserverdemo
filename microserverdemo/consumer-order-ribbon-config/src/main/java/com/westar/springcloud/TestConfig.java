package com.westar.springcloud;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeCommentScan
public class TestConfig {

    @Autowired
    private IClientConfig iClientConfig;

    /**
     * 创建
     * @param config
     * @return
     */
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();//返回随机负载均衡
    }
}
