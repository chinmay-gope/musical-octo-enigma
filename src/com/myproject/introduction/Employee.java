package com.myproject.introduction;

public class Employee {
    int empId;
    String empName, dept;
    float salary;

    void getEmployeeDetails(Employee emp) {
        IO.println("Employee ID: " + emp.empId);
        IO.println("Employee Name: " + emp.empName);
        IO.println("Employee Department: " + emp.dept);
        IO.println("Employee Salary: " + emp.salary);
    }

    void main() {
        Employee employee = new Employee();
        employee.empId = 101;
        employee.empName = "John Doe";
        employee.dept = "AIML";
        employee.salary = 30_000F;

        getEmployeeDetails(employee);
    }
}
