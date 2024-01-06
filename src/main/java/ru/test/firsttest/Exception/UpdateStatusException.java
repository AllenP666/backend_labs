package ru.test.firsttest.Exception;

import org.springframework.http.HttpStatus;

public class UpdateStatusException extends TaskException{
    public UpdateStatusException(String code, String message) {
        super(HttpStatus.BAD_REQUEST, code, message);
    }
}
