package ru.gpb.javacourse.client_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionResponse handleNotFoundException(NotFoundException notFoundException) {
        return ExceptionResponse.builder()
                .message(notFoundException.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .timestamp(now())
                .build();
    }
}
