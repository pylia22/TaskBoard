package com.uapp.task.oleg.trello.service;

import com.uapp.task.oleg.trello.entity.Column;
import com.uapp.task.oleg.trello.exception.ColumnNotFoundException;
import com.uapp.task.oleg.trello.exception.DuplicatedNameException;
import com.uapp.task.oleg.trello.repository.ColumnRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ColumnService {
    private final ColumnRepository columnRepository;

    public void create(Column column) {
        String columnName = column.getName();

        columnRepository.findColumnByName(columnName).ifPresent(optionalColumn -> {
            throw new DuplicatedNameException(columnName);
        });
        columnRepository.save(column);
    }

    public void update(Column newColumn, int id) {
        columnRepository.findById(id)
                .ifPresentOrElse(
                        column -> column.setName(newColumn.getName()),
                        ColumnNotFoundException::new);
    }

    public void deleteById(int id) {
       Optional<Column> optionalColumn = columnRepository.findById(id);
       if (optionalColumn.isEmpty()) {
           throw new ColumnNotFoundException();
       }
       columnRepository.deleteById(id);
    }
}
