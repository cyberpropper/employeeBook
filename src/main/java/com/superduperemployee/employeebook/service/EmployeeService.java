package com.superduperemployee.employeebook.service;

import com.superduperemployee.employeebook.exeption.EmployeeAlreadyAddedExeption;
import com.superduperemployee.employeebook.exeption.EmployeeNotFoundExeption;
import com.superduperemployee.employeebook.exeption.EmployeeStorageIsFullException;
import com.superduperemployee.employeebook.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final Map<String, Employee> employeesBook = new HashMap<>(Map.of());
    private int maxEmployees = Integer.MAX_VALUE;

    public EmployeeService() {
        demoFill();
    }

    public void demoFill() {
        employeesBook.clear();
        addEmployee("Виктор", "Кормушкин", 1, 12_000);
        addEmployee("Иван", "Печкин", 1, 21_000);
        addEmployee("Виталий", "Скидан", 1, 44000);
        addEmployee("Игнат", "Позневой", 2, 12_000);
        addEmployee("Артем", "Кавасаки", 2, 32_000);
        addEmployee("Влада", "Дуду", 1, 12000);
        addEmployee("Влад", "Смакт", 2, 55000);
        addEmployee("Наталья", "Арбузина", 3, 13_000);
        addEmployee("Елена", "Баловня", 3, 114_000);
        addEmployee("Алёна", "Прокофьева", 2, 3_000);
        setMaxEmployees(10);
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        if (employeesBook.size() > maxEmployees) throw new EmployeeStorageIsFullException();
        this.maxEmployees = maxEmployees;
    }

    @Override
    public Map<String, Employee> getEmployees() {
        return employeesBook;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employeesBook.size() >= maxEmployees) throw new EmployeeStorageIsFullException();
        try {
            findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundExeption e) {
            Employee employee = new Employee(firstName, lastName);
            employeesBook.put(employee.id(), employee);
            return employee;
        }
        throw new EmployeeAlreadyAddedExeption();
    }


    @Override
    public void addEmployee(String firstName, String lastName, int department, double salary) {
        final Employee newemployee = new Employee(firstName, lastName, department, salary);
        employeesBook.put(newemployee.id(), newemployee);
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employeesBook.remove(employee.id());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String id = new Employee(firstName, lastName).id();
        if (employeesBook.containsKey(id)) {
            return employeesBook.get(id);
        }
        throw new EmployeeNotFoundExeption();
    }


}