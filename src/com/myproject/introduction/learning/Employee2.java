package com.myproject.introduction.learning;

import java.util.Scanner;
import java.util.UUID;

public class Employee2 {
    static double salary;
    static float bonus;
    static boolean isPromoted;

    static void main() {
        Scanner sc = new Scanner(System.in);
        Employee2 emp = new Employee2();

        UUID empId = emp.getEmpId();

        System.out.print("MyEmployee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Salary: ");
        salary = sc.nextDouble();

        System.out.print("Enter Bonus (in %): ");
        bonus = sc.nextFloat();

        System.out.print("Enter Experience: ");
        byte experience = sc.nextByte();

        System.out.print("is Emp Permanently: ");
        boolean perm = sc.nextBoolean();

        sc.nextLine();

        System.out.print("Enter Mail ID: ");
        String mail = sc.nextLine();

        sc.close();

        emp.printDetails(empId, name, dept, salary, bonus, experience, perm, mail);

        emp.calcBonus(salary, bonus);
        emp.isPromoted(experience);
        emp.salaryAnalysis(salary);
    }

    void calcBonus(double salary, float bonusPercent) {
        double bonusAmt = salary * bonusPercent;
        double totalWithBonus = salary + bonusAmt;
        System.out.println("Bonus Amount: " + bonusAmt);
        System.out.println("Total Salary with Bonus: " + totalWithBonus);
    }

    void salaryAnalysis(double salary) {
        double b = salary * bonus;
        double annualSalary = salary * 12;
        double tax = annualSalary * 0.20; // 20% tax

        System.out.println("===Salary Analysis===");
        System.out.println("Monthly sal: " + salary);
        System.out.println("Annual sal: " + annualSalary);
        System.out.println("Bonus: " + b);
        System.out.println("Tax: " + tax);
        System.out.println("Net Ann Pay: " + (annualSalary - tax));
    }

    void isPromoted(byte exp) {
        if (exp >= 5) {
            System.out.println("MyEmployee is Promoted on Experience Bases");
            isPromoted = true;
        }
        System.out.println("is Promoted: " + isPromoted);
    }

    private void printDetails(UUID empId, String name, String dept, double salary,
                              float bonus, byte exp, boolean perm, String mail) {
        System.out.println("========== EMPLOYEE DETAILS ==========");
        System.out.println("MyEmployee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + dept);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Experience: " + exp);
        System.out.println("Permanent: " + perm);
        System.out.println("Mail: " + mail);
        System.out.println("is Promoted: " + isPromoted);
    }

    UUID getEmpId() {
        return UUID.randomUUID();
    }
}
