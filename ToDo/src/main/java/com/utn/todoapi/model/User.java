package com.utn.todoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String name;
    private String surname;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Task> taskList;
}
