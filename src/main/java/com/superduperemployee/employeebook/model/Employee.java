package com.superduperemployee.employeebook.model;

import org.springframework.http.HttpStatus;

public class Employee {

    private String firstName; // Имя сотрудника
    private String lastName;  // Фамилия сотрудника
    private int departmentId; // Идентификатор отдела
    private double salary;    // Зарплата сотрудника

    // Конструктор для создания объекта Employee
    public Employee(String firstName, String lastName, int departmentId, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    // Геттер для имени
    public String getFirstName() {
        return firstName;
    }

    // Сеттер для имени
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Геттер для фамилии
    public String getLastName() {
        return lastName;
    }

    // Сеттер для фамилии
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Геттер для идентификатора отдела
    public int getDepartmentId() {
        return departmentId;
    }

    // Сеттер для идентификатора отдела
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // Геттер для зарплаты
    public double getSalary() {
        return salary;
    }

    // Сеттер для зарплаты
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Переопределение метода toString для удобного вывода информации о сотруднике
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId=" + departmentId +
                ", salary=" + salary +
                '}';
    }

    // Переопределение метода equals для сравнения сотрудников
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (departmentId != employee.departmentId) return false;
        if (Double.compare(employee.salary, salary) != 0) return false;
        if (!firstName.equals(employee.firstName)) return false;
        return lastName.equals(employee.lastName);
    }

    // Переопределение метода hashCode для корректной работы с коллекциями
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + departmentId;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}