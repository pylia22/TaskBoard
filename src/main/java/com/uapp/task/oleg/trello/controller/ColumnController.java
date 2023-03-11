package com.uapp.task.oleg.trello.controller;

import com.uapp.task.oleg.trello.entity.Column;
import com.uapp.task.oleg.trello.service.ColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/columns")
@AllArgsConstructor
@Api("Column Controller")
public class ColumnController {
    private final ColumnService columnService;

    @PostMapping()
    @ApiOperation("Create new column")
    public ResponseEntity<String> create(@RequestBody Column column) {
        columnService.create(column);
        return new ResponseEntity<>("New column has been created", CREATED);
    }

    @PatchMapping("{id}")
    @ApiOperation("Update column")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Column column) {
        columnService.update(column, id);
        return new ResponseEntity<>("Column has been updated", OK);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete column")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        columnService.deleteById(id);
        return new ResponseEntity<>("Column has been deleted", OK);
    }
}
