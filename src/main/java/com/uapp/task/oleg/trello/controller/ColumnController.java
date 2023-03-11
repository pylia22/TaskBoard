package com.uapp.task.oleg.trello.controller;

import com.uapp.task.oleg.trello.dto.ColumnDto;
import com.uapp.task.oleg.trello.service.ColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
        columnService.create(columnDto);
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
