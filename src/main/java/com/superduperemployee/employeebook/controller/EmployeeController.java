package com.superduperemployee.employeebook.controller;


import com.superduperemployee.employeebook.service.DepartamentServiceInterface;
import com.superduperemployee.employeebook.service.EmployeeServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.superduperemployee.employeebook.exeption.EmployeeNotFoundExeption;
import com.superduperemployee.employeebook.exeption.EmployeeAlreadyAddedExeption;
import com.superduperemployee.employeebook.exeption.EmployeeStorageIsFullException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceInterface employeeService;
    private final DepartamentServiceInterface departmentService;


    public EmployeeController(EmployeeServiceInterface employeeService, DepartamentServiceInterface departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping
    public Object employeeList() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "/del")
    public Object employeeDelete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            return employeeService.deleteEmployee(firstName, lastName);
        } catch (EmployeeNotFoundExeption e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/add")
    public Object employeeAdd(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            return employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeAlreadyAddedExeption | EmployeeStorageIsFullException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/find")
    public Object employeeFind(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundExeption e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/departments/all", params = "departmentId")
    public Object employeeInDepartment(@RequestParam("departmentId") int department) {
        try {
            return departmentService.getEmployeesInDepartment(department);
        } catch (EmployeeNotFoundExeption e) {
            return e.getMessage();
        }
    }
    @GetMapping(path = "/departments/all")
    public Object employeeGroupByDepartment() {
        try {
            return departmentService.getEmployeesGroupByDepartment();
        } catch (EmployeeNotFoundExeption e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/departments/min-salary")
    public Object employeeMinSalary(@RequestParam("departmentId") int department) {
        try {
            return departmentService.getSalaryMin(department);
        } catch (EmployeeNotFoundExeption e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/departments/max-salary")
    public Object employeeMaxSalary(@RequestParam("departmentId") int department) {
        try {
            return departmentService.getSalaryMax(department);
        } catch (EmployeeNotFoundExeption e) {
            return e.getMessage();
        }
    }
}
