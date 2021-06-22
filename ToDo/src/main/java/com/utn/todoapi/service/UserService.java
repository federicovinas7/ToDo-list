package com.utn.todoapi.service;

import com.utn.todoapi.model.User;
import com.utn.todoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login (String email, String password){

        return userRepository.getUserByEmailAndPassword(email,password);
    }

    public User register(User user) {
        if(userRepository.getByEmail(user.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");
        return userRepository.save(user);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Email does not exists"));
    }

    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    public User update(User user){
        return userRepository.save(user);
    }
}
