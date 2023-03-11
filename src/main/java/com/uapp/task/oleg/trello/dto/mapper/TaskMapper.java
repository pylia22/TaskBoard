package com.uapp.task.oleg.trello.dto.mapper;

import com.uapp.task.oleg.trello.dto.TaskDto;
import com.uapp.task.oleg.trello.entity.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TaskMapper {

    public TaskDto toTaskDto(Task task) {
        return TaskDto.builder()
                .name(task.getName())
                .description(task.getDescription())
                .position(task.getPosition())
                .build();
    }

    public Task toTask(TaskDto taskDto) {
        return Task.builder()
                .name(taskDto.getName())
                .description(taskDto.getDescription())
                .position(taskDto.getPosition())
                .columnId(taskDto.getColumnId())
                .creationDate(LocalDate.now())
                .build();
    }
}
