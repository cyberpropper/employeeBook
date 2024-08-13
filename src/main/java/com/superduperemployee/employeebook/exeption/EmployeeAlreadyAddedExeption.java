package com.superduperemployee.employeebook.exeption;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedExeption extends RuntimeException{
    public EmployeeAlreadyAddedExeption() {
    }

    public EmployeeAlreadyAddedExeption(String message) {
        super(message);
    }

    public EmployeeAlreadyAddedExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyAddedExeption(Throwable cause) {
        super(cause);
    }

    public EmployeeAlreadyAddedExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
