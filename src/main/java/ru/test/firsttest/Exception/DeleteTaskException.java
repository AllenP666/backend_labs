package ru.test.firsttest.Exception;

import org.springframework.http.HttpStatus;

public class DeleteTaskException extends TaskException{
    public DeleteTaskException(String code, String message) {
        super(HttpStatus.BAD_REQUEST, code, message);
    }
}
