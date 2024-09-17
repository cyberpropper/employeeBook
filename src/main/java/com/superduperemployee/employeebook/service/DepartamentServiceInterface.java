package com.superduperemployee.employeebook.service;

import com.superduperemployee.employeebook.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartamentServiceInterface {

    Map<String, Employee> getEmployeesInDepartment(int department) throws IllegalArgumentException;
    Employee getSalaryMin(int department) throws IllegalArgumentException;
    Employee getSalaryMax(int department) throws IllegalArgumentException;
    Map<Integer, List<Employee>> getEmployeesGroupByDepartment();
}
