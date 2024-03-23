package ru.gozhan.softwaredevelopment2024backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.gozhan.softwaredevelopment2024backend.exception.CountryNotFoundException;
import ru.gozhan.softwaredevelopment2024backend.exception.Error;
import ru.gozhan.softwaredevelopment2024backend.exception.ErrorResponse;

@RestControllerAdvice
public class APIControllerAdvice {

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCountryNotFoundException(
            CountryNotFoundException e
    ) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        new Error(null, e.getMessage())
                ),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(
            Exception e
    ) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        new Error(null, e.getMessage())
                ),
                HttpStatus.BAD_REQUEST);
    }

}
