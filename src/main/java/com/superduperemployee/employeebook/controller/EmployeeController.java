package com.superduperemployee.employeebook.controller;


import com.superduperemployee.employeebook.model.Employee;
import com.superduperemployee.employeebook.service.DepartamentServiceInterface;
import com.superduperemployee.employeebook.service.EmployeeServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.superduperemployee.employeebook.exeption.EmployeeNotFoundExeption;
import com.superduperemployee.employeebook.exeption.EmployeeAlreadyAddedExeption;
import com.superduperemployee.employeebook.exeption.EmployeeStorageIsFullException;
import java.util.*;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceInterface employeeService;
    private final DepartamentServiceInterface departmentService;


    public EmployeeController(EmployeeServiceInterface employeeService, DepartamentServiceInterface departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @DeleteMapping
    public Object employeeList() {
        return employeeService.getEmployees();
    }

    @DeleteMapping(path = "/del")
    public ResponseEntity<Void> employeeDelete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.deleteEmployee(firstName, lastName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/add")
    public ResponseEntity<?> employeeAdd(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeService.addEmployee(firstName, lastName);
            return ResponseEntity.status(HttpStatus.CREATED).body(employee);
        } catch (EmployeeAlreadyAddedExeption e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EmployeeStorageIsFullException e) {
            return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).build();
        }
    }

    @GetMapping(path = "/find")
    public ResponseEntity<?> employeeFind(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeService.findEmployee(firstName, lastName);
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFoundExeption e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/departments/all", params = "departmentId")
    public ResponseEntity<?> employeeInDepartment(@RequestParam("departmentId") int department) {
        try {
            List<Employee> employees = (List<Employee>) departmentService.getEmployeesInDepartment(department);
            return ResponseEntity.ok(employees);
        } catch (EmployeeNotFoundExeption e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/departments/all")
    public ResponseEntity<?> employeeGroupByDepartment() {
        try {
            Map<Integer, List<Employee>> groupedEmployees = departmentService.getEmployeesGroupByDepartment();
            return ResponseEntity.ok(groupedEmployees);
        } catch (EmployeeNotFoundExeption e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/departments/min-salary")
    public ResponseEntity<?> employeeMinSalary(@RequestParam("departmentId") int department) {
        try {
            Employee minSalary = departmentService.getSalaryMin(department);
            return ResponseEntity.ok(minSalary);
        } catch (EmployeeNotFoundExeption e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/departments/max-salary")
    public ResponseEntity<?> employeeMaxSalary(@RequestParam("departmentId") int department) {
        try {
            Employee maxSalary = departmentService.getSalaryMax(department);
            return ResponseEntity.ok(maxSalary);
        } catch (EmployeeNotFoundExeption e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
