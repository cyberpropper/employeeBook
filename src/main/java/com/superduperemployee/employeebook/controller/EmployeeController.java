package com.superduperemployee.employeebook.controller;


import com.superduperemployee.employeebook.service.DepartamentServiceInterface;
import com.superduperemployee.employeebook.service.EmployeeServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.superduperemployee.employeebook.exeption.EmployeeAlreadyAddedExeption;
import com.superduperemployee.employeebook.exeption.EmployeeNotFoundExeption;
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
    public void employeeDelete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {}

    @GetMapping(path = "/add")
    public void employeeAdd(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
    }



    @GetMapping(path = "/find")
    public void employeeFind(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
    }


    @GetMapping(path = "/departments/all", params = "departmentId")
    public void employeeInDepartment(@RequestParam("departmentId") int department) {
    }
    @GetMapping(path = "/departments/all")
    public void employeeGroupByDepartment() {

    }

    @GetMapping(path = "/departments/min-salary")
    public void employeeMinSalary(@RequestParam("departmentId") int department) {
    }

    @GetMapping(path = "/departments/max-salary")
    public void employeeMaxSalary(@RequestParam("departmentId") int department) {
    }
}
