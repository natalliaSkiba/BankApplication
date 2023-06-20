package com.telran.bankapplication.controller.handler;

import com.telran.bankapplication.dto.ErrorExtensionDto;
import com.telran.bankapplication.dto.ErrorResponseDto;
import com.telran.bankapplication.service.exception.ErrorMessage;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice

public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDto> handlerConstraintViolationException(ConstraintViolationException exception) {
        List<ErrorExtensionDto> extensions = exception.getConstraintViolations()
                .stream()
                .map(violation -> new ErrorExtensionDto(violation.getMessage(), ErrorMessage.INVALID_PATH_VARIABLE))
                .collect(Collectors.toList());
        return new ResponseEntity<>(new ErrorResponseDto(ErrorMessage.VALIDATION_FAILED, extensions), BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<String> handlerValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        StringBuilder errorMessage = new StringBuilder();

        for (FieldError error : result.getFieldErrors()) {
            errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ");
        }
        return ResponseEntity.badRequest().body(errorMessage.toString());
    }
}
