package com.example.mzp.movie.controller;

import com.example.mzp.movie.entity.User;
import com.example.mzp.movie.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("movie/feign/{id}")
    public User getSomeone(@PathVariable Long id){
        return userFeign.getUser(id);
    }
}
