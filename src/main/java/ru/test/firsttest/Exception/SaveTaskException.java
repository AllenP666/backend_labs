package ru.test.firsttest.Exception;

import org.springframework.http.HttpStatus;

public class SaveTaskException extends TaskException{
    public SaveTaskException(String code, String message) {
        super(HttpStatus.BAD_REQUEST, code, message);
    }
}
