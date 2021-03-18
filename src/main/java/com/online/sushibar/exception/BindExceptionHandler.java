package com.online.sushibar.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static java.util.stream.Collectors.toList;


@ControllerAdvice(annotations = Controller.class)
public class BindExceptionHandler {

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<Object> handleBindException(BindException ex) {
        var bindingResult = ex.getBindingResult();

        var apiFieldErrors = bindingResult
                .getFieldErrors()
                .stream()
                .map(fe -> String.format("%s -> %s", fe.getField(), fe.getDefaultMessage()))
                .collect(toList());

        return ResponseEntity.unprocessableEntity()
                .body(apiFieldErrors);
    }

    @ExceptionHandler(IOException.class)
    protected String handleFileNotFoundEx() {
        return "file not found";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected String resourceNotFoundException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    protected String runtimeEx(RuntimeException ex) {
        return ex.getMessage();
    }
}
