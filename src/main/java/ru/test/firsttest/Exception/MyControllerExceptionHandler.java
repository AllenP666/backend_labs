package ru.test.firsttest.Exception;

import ru.test.firsttest.Controller.MyController;
import ru.test.firsttest.model.Task;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestControllerAdvice(basePackages = "ru.test.firsttest.Controller")
public @interface MyControllerExceptionHandler {
}
