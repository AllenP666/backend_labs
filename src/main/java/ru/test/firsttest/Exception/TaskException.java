package ru.test.firsttest.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class TaskException extends Exception{
    private final HttpStatus httpStatus;
    private final String code;
    public TaskException(HttpStatus httpStatus, String code, String message){
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
    }
}
