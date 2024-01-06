package ru.test.firsttest.Exception;

import org.springframework.http.HttpStatus;

public class EmptyResponseException extends TaskException{
    public EmptyResponseException(int code, String message){
        super(HttpStatus.NO_CONTENT, String.valueOf(code), message);
    }
}
