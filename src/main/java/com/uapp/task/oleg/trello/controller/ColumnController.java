package com.uapp.task.oleg.trello.controller;

import com.uapp.task.oleg.trello.dto.ColumnDto;
import com.uapp.task.oleg.trello.service.ColumnService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/columns")
@AllArgsConstructor
public class ColumnController {
    private final ColumnService columnService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody ColumnDto columnDto) {
        columnService.save(columnDto);
        return new ResponseEntity<>("New column has been created", CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ColumnDto columnDto) {
        columnService.update(columnDto, id);
        return new ResponseEntity<>("Column has been updated", OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        columnService.deleteById(id);
        return new ResponseEntity<>("Column has been deleted", OK);
    }
}
