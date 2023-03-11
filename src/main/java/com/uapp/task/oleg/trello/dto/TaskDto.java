package com.uapp.task.oleg.trello.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {

    @NotNull(message = "Task name must not be null")
    @NotEmpty(message = "Task name must not be empty")
    private String name;
    private String description;
    private int position = 1;
    private int columnId;
}
