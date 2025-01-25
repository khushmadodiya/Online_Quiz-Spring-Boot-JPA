package com.example.OnlineQuiz_JPA.controller;

import com.example.OnlineQuiz_JPA.Dao.UserRepo;
import com.example.OnlineQuiz_JPA.model.User;
import com.example.OnlineQuiz_JPA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;
    @PostMapping("/register")
    User register(@RequestBody User user){
        service.save(user);
        return  user;
    }
    @PostMapping("/login")
    String login(@RequestBody User user){
        return service.verify(user);

    }

}
