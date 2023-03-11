package com.uapp.task.oleg.trello.advice;

import com.uapp.task.oleg.trello.dto.ErrorResponse;
import com.uapp.task.oleg.trello.exception.ColumnNotFoundException;
import com.uapp.task.oleg.trello.exception.DuplicatedNameException;
import com.uapp.task.oleg.trello.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
@AllArgsConstructor
public class ExceptionHandler {

    private final ResponseUtil responseUtil;

    @org.springframework.web.bind.annotation.ExceptionHandler(DuplicatedNameException.class)
    public ResponseEntity<ErrorResponse> handleDuplicatedNameException(DuplicatedNameException ex) {
        ErrorResponse errorResponse = responseUtil.createGeneralErrorResponse(ex.getReason());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ColumnNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(ColumnNotFoundException ex) {
        ErrorResponse errorResponse = responseUtil.createGeneralErrorResponse(ex.getReason());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .filter(Objects::nonNull)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(". "));

        ErrorResponse errorResponse = responseUtil.createGeneralErrorResponse(errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
