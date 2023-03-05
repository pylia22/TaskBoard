package com.uapp.task.oleg.trello.controller;

import com.uapp.task.oleg.trello.entity.Column;
import com.uapp.task.oleg.trello.repository.ColumnRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("columns")
@AllArgsConstructor
public class ColumnController {
    private final ColumnRepository columnRepository;

    @PostMapping
    public ResponseEntity<Column> create(@RequestBody Column column) {
        columnRepository.save(column);
        return new ResponseEntity<>(column, HttpStatus.CREATED);
    }
}
