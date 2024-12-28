package com.superduperemployee.employeebook.service;

import com.superduperemployee.employeebook.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private final List<Employee> employees = new ArrayList<>(); // Список сотрудников

    // Добавление сотрудника
    public void addEmployee(Employee employee) {
        if (employees.contains(employee)) {
            throw new IllegalArgumentException("Сотрудник уже существует в списке.");
        }
        employees.add(employee);
    }

    // Удаление сотрудника по имени и фамилии
    public void removeEmployee(String firstName, String lastName) {
        Employee employeeToRemove = findEmployee(firstName, lastName);
        if (employeeToRemove == null) {
            throw new IllegalArgumentException("Сотрудник не найден.");
        }
        employees.remove(employeeToRemove);
    }

    // Поиск сотрудника по имени и фамилии
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        return null;
    }

    // Получение списка всех сотрудников
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees); // Возвращаем копию списка
    }
}