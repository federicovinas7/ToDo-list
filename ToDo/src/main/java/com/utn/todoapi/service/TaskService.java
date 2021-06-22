package com.utn.todoapi.service;

import com.utn.todoapi.model.Task;
import com.utn.todoapi.model.User;
import com.utn.todoapi.repository.FolderRepository;
import com.utn.todoapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepo;
    private final UserService userService;

    @Autowired
    public TaskService(TaskRepository taskRepo, UserService userService) {
        this.taskRepo = taskRepo;
        this.userService = userService;
    }

    public List<Task> getAll(Integer userId){
        return this.taskRepo.findAllByUserId(userId);
    }

    public Task getById(Integer userId, Integer idTask){
        return this.taskRepo.findByUserIdAndTaskId(userId, idTask)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Task id: " + idTask + " does not exists."));
    }

    public Task add(Integer userId, Task newTask){
        User user = this.userService.getById(userId);
        Task saved = this.taskRepo.save(newTask);
        user.getTaskList().add(saved);
        this.userService.update(user);
        return saved;
    }

    public void delete(Integer userId, Integer idTask){
        Task toDelete = this.taskRepo.findByUserIdAndTaskId(userId, idTask)
                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task id: " + idTask + " doest not exists for requested user."));

        this.taskRepo.deleteById(idTask);
    }

    public boolean update(Integer userId, Task toEdit){
        boolean updated = false;
        if(taskRepo.findByUserIdAndTaskId(userId,toEdit.getId()).isPresent()) {
            taskRepo.save(toEdit);
            updated = true;
        }
        else {
            if(taskRepo.findById(toEdit.getId()).isPresent()) {
                toEdit.setId(null);
            }
            add(userId, toEdit);
        }

        return updated;
    }
}
