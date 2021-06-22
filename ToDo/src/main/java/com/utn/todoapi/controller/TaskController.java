package com.utn.todoapi.controller;

import com.utn.todoapi.model.DTO.UserDTO;
import com.utn.todoapi.model.Task;
import com.utn.todoapi.model.User;
import com.utn.todoapi.service.TaskService;
import com.utn.todoapi.service.UserService;
import com.utn.todoapi.utils.EntityUrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;

import static com.utn.todoapi.utils.Response.response;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity getAll(Authentication auth){

        return response(this.taskService.getAll(getLoggedId(auth)));
    }

    @GetMapping("/{idTask}")
    public ResponseEntity getById(Authentication auth, @PathVariable Integer idTask){
        return response(this.taskService.getById(getLoggedId(auth),idTask));
    }

    @PostMapping
    public ResponseEntity add(Authentication auth, @RequestBody Task newTask){
        return response(taskService.add(getLoggedId(auth),newTask));
    }

    @DeleteMapping("/{idTask}")
    public ResponseEntity delete(Authentication auth, @PathVariable Integer idTask){
        this.taskService.delete(getLoggedId(auth), idTask);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity update(Authentication auth, @RequestBody Task toUpdate){
        Integer userId = getLoggedId(auth);
        if (!taskService.update(userId, toUpdate))
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(EntityUrlBuilder.buildURL("/users/" + userId.toString() + "/tasks", toUpdate.getId().toString()));
        return ResponseEntity.ok().build();
    }

    private Integer getLoggedId(Authentication auth){
        User loggedUser = this.userService.getByEmail( ((UserDTO) auth.getPrincipal()).getEmail() );
        return loggedUser.getId();
    }
}
