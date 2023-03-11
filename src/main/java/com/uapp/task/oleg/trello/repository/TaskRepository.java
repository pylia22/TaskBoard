package com.uapp.task.oleg.trello.repository;

import com.uapp.task.oleg.trello.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findTaskByNameAndColumnId(String name, int id);
}
