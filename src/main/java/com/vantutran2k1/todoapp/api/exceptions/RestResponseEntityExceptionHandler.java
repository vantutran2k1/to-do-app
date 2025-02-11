package com.vantutran2k1.todoapp.api.exceptions;

import com.vantutran2k1.todoapp.api.payloads.ApiError;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {
            EntityNotFoundException.class
    })
    protected ResponseEntity<ApiError> handleEntityNotFound(RuntimeException ex) {
        return this.buildErrorResponseEntity(ex, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {
            UserExistException.class,
    })
    protected ResponseEntity<ApiError> handleBadRequest(RuntimeException ex) {
        return this.buildErrorResponseEntity(ex, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {
            UnauthorizedException.class,
    })
    protected ResponseEntity<ApiError> handleUnauthorizedRequest(RuntimeException ex) {
        return this.buildErrorResponseEntity(ex, null, HttpStatus.UNAUTHORIZED);
    }

    @Override
    @ResponseBody
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    String fieldName = camelToSnake(((FieldError) error).getField());
                    String message = error.getDefaultMessage();
                    errors.put(fieldName, message);
                });

        ApiError apiError = ApiError.builder()
                .error(errors)
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }

    private ResponseEntity<ApiError> buildErrorResponseEntity(
            final RuntimeException ex,
            final Object error,
            final HttpStatus status
    ) {
        String errorMessage = ex.getLocalizedMessage();
        ApiError apiError;
        if (error != null) {
            apiError = ApiError.builder().message(errorMessage).error(error).status(status).build();
        } else {
            apiError = ApiError.builder().message(errorMessage).status(status).build();
        }

        return new ResponseEntity<>(apiError, status);
    }

    private String camelToSnake(String camelCase) {
        StringBuilder snakeCase = new StringBuilder();
        for (int i = 0; i < camelCase.length(); i++) {
            char c = camelCase.charAt(i);
            if (Character.isUpperCase(c)) {
                snakeCase.append("_").append(Character.toLowerCase(c));
            } else {
                snakeCase.append(c);
            }
        }

        if (snakeCase.charAt(0) == '_') {
            snakeCase.deleteCharAt(0);
        }
        return snakeCase.toString();
    }
}
