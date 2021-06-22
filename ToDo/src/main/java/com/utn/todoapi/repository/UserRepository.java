package com.utn.todoapi.repository;

import com.utn.todoapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    User getUserByEmailAndPassword(String email, String password);

    @Query(value="SELECT * FROM user WHERE email = ?1", nativeQuery = true)
    Optional<User> getByEmail(String email);
}
