package com.superduperemployee.employeebook.service;

import com.superduperemployee.employeebook.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartamentServiceInterface {
    int ALL_DEPARTMENTS = -1;

    void Init();

    Map<String, Employee> getEmployeesInDepartment(int department);
    Employee getSalaryMin(int department);
    Employee getSalaryMax(int department);
    Map<Integer, List<Employee>> getEmployeesGroupByDepartment();
}
