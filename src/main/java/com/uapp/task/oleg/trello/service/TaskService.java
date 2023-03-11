package com.uapp.task.oleg.trello.service;

import com.uapp.task.oleg.trello.dto.TaskDto;
import com.uapp.task.oleg.trello.dto.mapper.TaskMapper;
import com.uapp.task.oleg.trello.entity.Column;
import com.uapp.task.oleg.trello.entity.Task;
import com.uapp.task.oleg.trello.exception.ColumnNotFoundException;
import com.uapp.task.oleg.trello.exception.DuplicatedNameException;
import com.uapp.task.oleg.trello.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final ColumnService columnService;

    @Transactional
    public void save(TaskDto taskDto) {
        String taskName = taskDto.getName();
        int columnId = taskDto.getColumnId();
        columnService.checkIfColumnPresent(columnId);

        taskRepository.findTaskByNameAndColumnId(taskName, columnId).ifPresent(optionalTask -> {
            throw new DuplicatedNameException("Task name " + taskName + " already exists");
        });
        Task task = taskMapper.toTask(taskDto);
        taskRepository.save(task);
    }

    public void update(TaskDto taskDto, int id) {
        Task updatedTask = taskRepository.findById(id)
                .map(task -> {
                    task.setName(taskDto.getName());
                    task.setPosition(taskDto.getPosition());
                    task.setDescription(taskDto.getDescription());
                    task.setColumnId(task.getColumnId());
                    return task;
                })
                .orElseThrow(ColumnNotFoundException::new);

        taskRepository.save(updatedTask);
    }
}
