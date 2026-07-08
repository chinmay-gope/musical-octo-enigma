package com.myproject.introduction;

import java.util.Scanner;

public class MyStudent {

    String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }

    double calculateCGPA(double totalPoints, int semesters) {
        return semesters > 0 ? totalPoints / semesters : 0.0;
    }

    double calculateAttendance(double attended, double totalClasses) {
        return totalClasses > 0 ? (attended / totalClasses) * 100 : 0.0;
    }

    String getResult(int marks) {
        return marks >= 40 ? "Pass" : "Fail";
    }

    boolean calculateScholarship(double cgpa) {
        return cgpa >= 8.0;
    }

    double calculateAverageMarks(int m1, int m2, int m3) {
        return (m1 + m2 + m3) / 3.0;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        MyStudent student = new MyStudent();

        System.out.print("Enter percentage: ");
        double percentage = sc.nextDouble();
        System.out.println("Grade: " + student.calculateGrade(percentage));

        System.out.print("Enter total points: ");
        double points = sc.nextDouble();
        System.out.print("Enter number of semesters: ");
        int semesters = sc.nextInt();
        System.out.println("CGPA: " + student.calculateCGPA(points, semesters));

        System.out.print("Enter attended classes: ");
        int attended = sc.nextInt();
        System.out.print("Enter total classes: ");
        int total = sc.nextInt();
        System.out.println("Attendance: " + student.calculateAttendance(attended, total) + "%");

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();
        System.out.println("Result: " + student.getResult(marks));

        System.out.print("Enter CGPA for scholarship check: ");
        double cgpa = sc.nextDouble();
        System.out.println("Scholarship Eligible: " + student.calculateScholarship(cgpa));

        System.out.print("Enter marks for 3 subjects: ");
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        System.out.println("Average Marks: " + student.calculateAverageMarks(m1, m2, m3));
    }
}
