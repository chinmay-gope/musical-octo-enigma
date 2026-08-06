package com.myproject.introduction.learning;

import java.util.Scanner;

public class MyEmployee {

    double calculateSalary(double basic, double bonus) {
        return basic + bonus;
    }

    double calculateTax(double salary) {
        // Simple rule: 10% tax
        return salary * 0.10;
    }

    double calculateHRA(double basic) {
        // House Rent Allowance: 20% of basic
        return basic * 0.20;
    }

    double calculateDA(double basic) {
        // Dearness Allowance: 15% of basic
        return basic * 0.15;
    }

    double calculateNetSalary(double basic, double deduction) {
        return basic - deduction;
    }

    double calculateBonus(double salary, double percentage) {
        return salary * (percentage / 100);
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        MyEmployee emp = new MyEmployee();

        // Salary
        System.out.print("Enter basic salary: ");
        double basic = sc.nextDouble();
        System.out.print("Enter bonus: ");
        double bonus = sc.nextDouble();
        double totalSalary = emp.calculateSalary(basic, bonus);
        System.out.println("Total Salary: " + totalSalary);

        // Tax
        double tax = emp.calculateTax(totalSalary);
        System.out.println("Tax (10%): " + tax);

        // HRA & DA
        System.out.println("HRA (20% of basic): " + emp.calculateHRA(basic));
        System.out.println("DA (15% of basic): " + emp.calculateDA(basic));

        // Net Salary
        System.out.print("\nEnter deductions: ");
        double deduction = sc.nextDouble();
        System.out.println("Net Salary: " + emp.calculateNetSalary(totalSalary, deduction));

        // Bonus by percentage
        System.out.print("\nEnter bonus percentage: ");
        double bonusPercent = sc.nextDouble();
        System.out.println("Calculated Bonus: " + emp.calculateBonus(totalSalary, bonusPercent));

        sc.close();
    }
}
