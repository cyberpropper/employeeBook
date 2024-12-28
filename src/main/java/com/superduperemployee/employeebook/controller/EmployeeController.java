package com.superduperemployee.employeebook.controller;

import com.superduperemployee.employeebook.model.Employee;
import com.superduperemployee.employeebook.service.EmployeeServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceInterface employeeService;

    // Внедрение зависимости через конструктор
    public EmployeeController(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    // Добавление сотрудника
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    // Удаление сотрудника по имени и фамилии
    @DeleteMapping("/{firstName}/{lastName}")
    public String removeEmployee(@PathVariable String firstName, @PathVariable String lastName) {
        employeeService.removeEmployee(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " удален.";
    }

    // Поиск сотрудника по имени и фамилии
    @GetMapping("/{firstName}/{lastName}")
    public Employee findEmployee(@PathVariable String firstName, @PathVariable String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    // Получение списка всех сотрудников
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
