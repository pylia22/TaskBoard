package com.uapp.task.oleg.trello.dto.mapper;

import com.uapp.task.oleg.trello.dto.ColumnDto;
import com.uapp.task.oleg.trello.entity.Column;
import org.springframework.stereotype.Component;

@Component
public class ColumnMapper {

    public ColumnDto toColumnDto(Column column) {
        return ColumnDto.builder()
                .name(column.getName())
                .position(column.getPosition())
                .build();
    }

    public Column toColumn(ColumnDto columnDto) {
        return Column.builder()
                .name(columnDto.getName())
                .position(columnDto.getPosition())
                .build();
    }
}
