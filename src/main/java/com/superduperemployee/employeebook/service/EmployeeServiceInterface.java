package com.superduperemployee.employeebook.service;

import com.superduperemployee.employeebook.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeServiceInterface {
    void addEmployee(Employee employee);
    void removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> getAllEmployees();
}
