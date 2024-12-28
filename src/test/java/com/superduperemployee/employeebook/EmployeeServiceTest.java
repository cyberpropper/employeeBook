package com.superduperemployee.employeebook;

import com.superduperemployee.employeebook.model.Employee;
import com.superduperemployee.employeebook.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        employeeService.addEmployee(employee);
        assertEquals(1, employeeService.getAllEmployees().size());
    }

    @Test
    void testAddDuplicateEmployee() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        employeeService.addEmployee(employee);
        assertThrows(IllegalArgumentException.class, () -> employeeService.addEmployee(employee));
    }

    @Test
    void testRemoveEmployee() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        employeeService.addEmployee(employee);
        employeeService.removeEmployee("John", "Doe");
        assertEquals(0, employeeService.getAllEmployees().size());
    }

    @Test
    void testRemoveNonExistentEmployee() {
        assertThrows(IllegalArgumentException.class, () -> employeeService.removeEmployee("John", "Doe"));
    }

    @Test
    void testFindEmployee() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        employeeService.addEmployee(employee);
        assertEquals(employee, employeeService.findEmployee("John", "Doe"));
    }

    @Test
    void testFindNonExistentEmployee() {
        assertNull(employeeService.findEmployee("John", "Doe"));
    }
}