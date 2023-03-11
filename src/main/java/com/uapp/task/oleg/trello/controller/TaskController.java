package com.uapp.task.oleg.trello.controller;

import com.uapp.task.oleg.trello.dto.TaskDto;
import com.uapp.task.oleg.trello.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<String> createTask(@Valid @RequestBody TaskDto taskDto) {
        taskService.save(taskDto);
        return new ResponseEntity<>("Task is successfully created", CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTask(@Valid @PathVariable int id, @RequestBody TaskDto taskDto) {
        taskService.update(taskDto, id);
        return new ResponseEntity<>("Task is successfully updated", OK);
    }
}
