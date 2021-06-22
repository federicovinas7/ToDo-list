package com.utn.todoapi.repository;

import com.utn.todoapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    @Query(value="SELECT * FROM task WHERE user_id =?1", nativeQuery = true)
    List<Task> findAllByUserId(Integer userId);

    @Query(value="SELECT * FROM task WHERE user_id =?1 AND id = ?2", nativeQuery = true)
    Optional<Task> findByUserIdAndTaskId(Integer userId, Integer idTask);
}
