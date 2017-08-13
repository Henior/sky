package com.example.mzp.movie.controller;

import com.example.mzp.movie.entity.User;
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
    public User getSomeone(@PathVariable Long id){
        return restTemplate.getForEntity("http://provider-user/user/"+id,User.class).getBody();
    }

    @GetMapping("ribbon")
    public String getWhichIp(){
       return LoadBalancerClient.choose("provider-user").getUri().toString();
    }
}
