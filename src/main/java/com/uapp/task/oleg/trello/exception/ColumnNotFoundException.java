package com.uapp.task.oleg.trello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ColumnNotFoundException extends ResponseStatusException {
    public ColumnNotFoundException() {
        super(NOT_FOUND, "Column was not found");
    }
}
