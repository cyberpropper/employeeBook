package com.superduperemployee.employeebook.exeption;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundExeption extends RuntimeException{
    public EmployeeNotFoundExeption() {
    }

    public EmployeeNotFoundExeption(String message) {
        super(message);
    }

    public EmployeeNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundExeption(Throwable cause) {
        super(cause);
    }

    public EmployeeNotFoundExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
