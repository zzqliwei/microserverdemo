package com.westar.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.westar.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    private String url = "http://127.0.0.1:7900/user/";

//    @Value("${user.url}")
//    private String url;

    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable("id") Long id){

      /*  InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("PROVIDER-USER",false);
        String url = instanceInfo.getHomePageUrl();*/
        //访问提供者回去数据
        User user = restTemplate.getForObject("http://PROVIDER-USER/user/"+id,User.class);
        return user;
    }
    @GetMapping("/test")
    public void test(){
        ServiceInstance serviceInstance1 = loadBalancerClient.choose("PROVIDER-USER");
        System.out.println("1111：" + serviceInstance1.getServiceId() +":"+ serviceInstance1.getHost() +":"+serviceInstance1.getPort());
        ServiceInstance serviceInstance2 = loadBalancerClient.choose("PROVIDER-USER1");
        System.out.println("222：" + serviceInstance2.getServiceId() +":"+ serviceInstance2.getHost() +":"+serviceInstance2.getPort());
    }

}
