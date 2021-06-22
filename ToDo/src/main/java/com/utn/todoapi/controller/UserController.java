package com.utn.todoapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utn.todoapi.model.DTO.LoginRequest;
import com.utn.todoapi.model.DTO.LoginResponse;
import com.utn.todoapi.model.DTO.RegisterRequest;
import com.utn.todoapi.model.DTO.UserDTO;
import com.utn.todoapi.model.User;
import com.utn.todoapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.utn.todoapi.utils.Constants.AUTH_USER;
import static com.utn.todoapi.utils.Constants.JWT_SECRET;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserController(UserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws JsonProcessingException {
        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if(user != null){
            UserDTO userDTO = new UserDTO(user.getId(),user.getEmail(),user.getName(),user.getSurname());
            return ResponseEntity.ok(LoginResponse.builder().token(this.generateToken(userDTO)).build());
        } else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid username or password.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody RegisterRequest registerRequest){

        User saved = userService.register(objectMapper.convertValue(registerRequest,User.class));
        return ResponseEntity.created(ServletUriComponentsBuilder
                                    .fromCurrentRequest()
                                    .path("/{entity}")
                                    .buildAndExpand(saved.getId())
                                    .toUri())
                                    .build();
    }

    private String generateToken(UserDTO userDTO) throws JsonProcessingException {
        String authRole = AUTH_USER;

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(authRole);
        String token = Jwts.builder()
                .setId("JWT")
                .setSubject(userDTO.getEmail())
                .claim("user",objectMapper.writeValueAsString(userDTO))
                .claim("authorities",grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis() + 1800000 ))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET.getBytes()).compact();

        return token;
    }
}
