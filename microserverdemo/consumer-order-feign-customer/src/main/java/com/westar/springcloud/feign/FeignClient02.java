package com.westar.springcloud.feign;

import com.westar.conf.FeignClient01Config;
import com.westar.conf.FeignClient02Config;
import com.westar.springcloud.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "provider-useraa",url="http://192.168.1.55:10000",configuration = FeignClient02Config.class)
public interface FeignClient02 {
    @GetMapping("/eureka/apps/{serviceName}") //组合注解
    public String getServiceInfo(@PathVariable("serviceName") String serviceName);

}
