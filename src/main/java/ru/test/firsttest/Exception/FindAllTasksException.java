package ru.test.firsttest.Exception;

import org.springframework.http.HttpStatus;

public class FindAllTasksException extends TaskException{
    public FindAllTasksException(String code, String message){
        super(HttpStatus.NO_CONTENT, String.valueOf(code), message);
    }
}
