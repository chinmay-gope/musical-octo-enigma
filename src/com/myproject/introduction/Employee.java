package com.myproject.introduction;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Employee {
    static UUID emp_id = UUID.randomUUID();

    String emp_name;
    Double salary;
    Double bonus;
    Integer experience;
    String hire_date = LocalDate.now().toString();

    Employee(String emp_name,
             Double salary,
             Double bonus,
             Integer experience) {
        this.emp_name = emp_name;
        this.salary = salary;
        this.bonus = bonus;
        this.experience = experience;

        showDetails();
    }

    void showDetails() {
        System.out.println("Emp ID: " + emp_id);
        System.out.println("Emp Name: " + emp_name);
        System.out.println("Salary: " + salary + ", Has Bonus: " + bonus * 100 + " %");

        bonus = salary * bonus; // 5000 * 0.1
        System.out.println("Bonus : " + bonus);

        System.out.println("Annual Amount : " + (salary + bonus));
        System.out.println("Hire Date : " + hire_date);
        System.out.println("Experience in Yrs: " + experience);
        System.out.println("_________________________________");
    }

    static void main() {
        new Employee("John Doe", 5000.0, 0.1, 2);
        new Employee("Jane Doe", 3000.0, 0.3, 1);
        new Employee("Bill Gates", 8000.0, 0.4, 3);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name: ");
        String emp_name = sc.nextLine();
        System.out.println("Enter employee salary: ");
        Double salary = sc.nextDouble();
        System.out.println("Enter employee bonus: ");
        Double bonus = sc.nextDouble();
        System.out.println("Enter employee Experience: ");
        Integer experience = sc.nextInt();

        new Employee(emp_name, salary, bonus, experience);
    }
}
