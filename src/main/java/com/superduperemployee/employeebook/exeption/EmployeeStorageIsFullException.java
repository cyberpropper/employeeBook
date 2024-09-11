package com.superduperemployee.employeebook.exeption;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Достигнуто максимальное количество сотрудников в фирме");
    }
}