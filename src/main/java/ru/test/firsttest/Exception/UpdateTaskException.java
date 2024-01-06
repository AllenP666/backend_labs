package ru.test.firsttest.Exception;

import org.springframework.http.HttpStatus;

public class UpdateTaskException extends TaskException{
    public UpdateTaskException(String code, String message) {
        super(HttpStatus.BAD_REQUEST, code, message);
    }
}
