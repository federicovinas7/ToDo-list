package com.utn.todoapi.service;

import com.utn.todoapi.model.User;
import com.utn.todoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login (String username, String password){

        return userRepository.getUserByUsernameAndPassword(username,password);
    }

    public User register(User user) {

        return userRepository.save(user);
    }
}
