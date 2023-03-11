package com.uapp.task.oleg.trello.service;

import com.uapp.task.oleg.trello.dto.ColumnDto;
import com.uapp.task.oleg.trello.dto.mapper.ColumnMapper;
import com.uapp.task.oleg.trello.entity.Column;
import com.uapp.task.oleg.trello.exception.ColumnNotFoundException;
import com.uapp.task.oleg.trello.exception.DuplicatedNameException;
import com.uapp.task.oleg.trello.repository.ColumnRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ColumnService {
    private final ColumnRepository columnRepository;
    private final ColumnMapper columnMapper;

    public void save(ColumnDto columnDto) {
        String columnName = columnDto.getName();

        columnRepository.findColumnByName(columnName).ifPresent(optionalColumn -> {
            throw new DuplicatedNameException("Column name " + columnName + " already exists");
        });
        Column column = columnMapper.toColumn(columnDto);
        columnRepository.save(column);
    }

    @Transactional
    public void update(ColumnDto columnDto, int id) {
        Column updatedColumn = columnRepository.findById(id)
                .map(column -> {
                    column.setName(columnDto.getName());
                    column.setPosition(columnDto.getPosition());
                    return column;
                })
                .orElseThrow(ColumnNotFoundException::new);

        columnRepository.save(updatedColumn);
    }

    public void deleteById(int id) {
        Optional<Column> optionalColumn = columnRepository.findById(id);
        if (optionalColumn.isEmpty()) {
            throw new ColumnNotFoundException();
        }
        columnRepository.deleteById(id);
    }

    public void checkIfColumnPresent(int id) {
        Optional<Column> optionalColumn = columnRepository.findById(id);
        if (optionalColumn.isEmpty()) {
            throw new ColumnNotFoundException();
        }
    }
}
