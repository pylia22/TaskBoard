package com.uapp.task.oleg.trello.util;

import com.uapp.task.oleg.trello.dto.ErrorResponse;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class ResponseUtil {

    public ErrorResponse createGeneralErrorResponse(String message) {
        return ErrorResponse.builder()
                .dateTime(Instant.now())
                .message(message)
                .build();
    }
}
