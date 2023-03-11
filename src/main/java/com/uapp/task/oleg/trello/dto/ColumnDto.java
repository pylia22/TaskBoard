package com.uapp.task.oleg.trello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColumnDto {

    @NotNull
    private String name;

    @NotNull
    private int position;
}
