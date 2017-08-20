package com.example.mzp.movie.controller;

import com.example.mzp.movie.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient LoadBalancerClient;

    @GetMapping("movie/rest/{id}")
    @HystrixCommand(fallbackMethod = "getSomeoneHystrix",commandProperties =  @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"))
    public User getSomeone(@PathVariable Long id){
        System.err.println(Thread.currentThread().getName());
        return restTemplate.getForEntity("http://provider-user/user/"+id,User.class).getBody();
    }

    public User getSomeoneHystrix(Long id){
        System.err.println(Thread.currentThread().getName());
        User user = new User();
        user.setId(id);
        return user;
    }
    @GetMapping("ribbon")
    public String getWhichIp(){
       return LoadBalancerClient.choose("provider-user").getUri().toString();
    }
}
