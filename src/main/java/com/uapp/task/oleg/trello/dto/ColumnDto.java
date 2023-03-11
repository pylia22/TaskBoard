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
public class ColumnDto {

    @NotNull(message = "Column name must not be null")
    @NotEmpty(message = "Column name must not be empty")
    private String name;

    @NotNull
    private int position = 1;
}
