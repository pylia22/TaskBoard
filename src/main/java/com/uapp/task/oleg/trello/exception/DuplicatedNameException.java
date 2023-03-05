package com.uapp.task.oleg.trello.exception;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


public class DuplicatedNameException extends ResponseStatusException {

    public DuplicatedNameException(String s) {
        super(BAD_REQUEST, "Column with " + s + " name already exists");
    }
}
