package com.example.mzp.user.controller;

import com.example.mzp.user.entity.User;
import com.example.mzp.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("user/{id}")
    public User getSomeone(@PathVariable Long id){
        return userRepository.findOne(id);
    }

    @GetMapping("movie/rest/{id}")
    public User getSomeoneMovie(@PathVariable Long id){
        return userRepository.findOne(id);
    }
}
