package com.vantutran2k1.todoapp.api.exceptions;

public class UserExistException extends RuntimeException {
    public UserExistException(String message) {
        super(message);
    }
}
