package com.superduperemployee.employeebook.service;

import com.superduperemployee.employeebook.exeption.EmployeeAlreadyAddedExeption;
import com.superduperemployee.employeebook.exeption.EmployeeNotFoundExeption;
import com.superduperemployee.employeebook.model.Employee;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeelist;

    public EmployeeServiceImpl() {
        this.employeelist = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeelist.contains(employee)) {
            throw new EmployeeAlreadyAddedExeption();
        }
        employeelist.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeelist.contains(employee)) {
            employeelist.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundExeption();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employeelist.contains(employee)) {
            return employee;
        }

        throw new EmployeeNotFoundExeption();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeelist);
    }
}
