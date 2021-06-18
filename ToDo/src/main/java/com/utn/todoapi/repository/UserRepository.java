package com.utn.todoapi.repository;

import com.utn.todoapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    User getUserByUsernameAndPassword(String username, String password);
}
