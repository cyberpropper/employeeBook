package com.superduperemployee.employeebook;
import com.superduperemployee.employeebook.model.Employee;
import com.superduperemployee.employeebook.service.DepartamentService;
import com.superduperemployee.employeebook.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartamentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeesByDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(
                new Employee("John", "Doe", 1, 50000),
                new Employee("Jane", "Doe", 2, 60000)
        ));

        List<Employee> employees = departmentService.getEmployeesByDepartment(1);
        assertEquals(1, employees.size());
        assertEquals("John", employees.get(0).getFirstName());
    }

    @Test
    void testGetSumSalaryByDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(
                new Employee("John", "Doe", 1, 50000),
                new Employee("Jane", "Doe", 1, 60000)
        ));

        double sum = departmentService.getSumSalaryByDepartment(1);
        assertEquals(110000, sum);
    }

    @Test
    void testGetMaxSalaryByDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(
                new Employee("John", "Doe", 1, 50000),
                new Employee("Jane", "Doe", 1, 60000)
        ));

        double max = departmentService.getMaxSalaryByDepartment(1);
        assertEquals(60000, max);
    }

    @Test
    void testGetMinSalaryByDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(
                new Employee("John", "Doe", 1, 50000),
                new Employee("Jane", "Doe", 1, 60000)
        ));

        double min = departmentService.getMinSalaryByDepartment(1);
        assertEquals(50000, min);
    }

    @Test
    void testGetEmployeesGroupedByDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(
                new Employee("John", "Doe", 1, 50000),
                new Employee("Jane", "Doe", 2, 60000)
        ));

        Map<Integer, List<Employee>> groupedEmployees = departmentService.getEmployeesGroupedByDepartment();
        assertEquals(2, groupedEmployees.size());
        assertEquals(1, groupedEmployees.get(1).size());
        assertEquals(1, groupedEmployees.get(2).size());
    }
}