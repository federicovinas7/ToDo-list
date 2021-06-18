package com.utn.todoapi.controller;

import com.utn.todoapi.model.User;
import com.utn.todoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User login(@PathVariable String username, @PathVariable String password){

        return userService.login(username,password);
    }

    @PostMapping("/register")
    public User register (@RequestBody User user){

        return userService.register(user);
    }
}
