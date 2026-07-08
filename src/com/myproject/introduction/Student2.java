package com.myproject.introduction;

import java.util.Scanner;

public class Student2 {


    static void main() {
        Scanner sc = new Scanner(System.in);
        Student2 student = new Student2();

        System.out.print("Enter Roll No: ");
        int rollNo = sc.nextInt();

        sc.nextLine();   // Consume newline

        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Gender (M/F): ");
        char gender = sc.next().toUpperCase().charAt(0);

        System.out.print("Enter height in cm: ");
        double height = sc.nextDouble();

        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();

        sc.nextLine();   // Consume newline

        System.out.print("Enter Street Address: ");
        String address = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

        System.out.print("Enter Country: ");
        String country = sc.nextLine();

        System.out.print("Enter Zip Code: ");
        int zip = sc.nextInt();

        System.out.print("Enter Phone no: ");
        long phoneNumber = sc.nextLong();

        System.out.print("Enter CGPA: ");
        float cgpa = sc.nextFloat();

        System.out.println("Do u live in Hostel (true/false)");
        boolean hosteler = sc.nextBoolean();

        sc.nextLine(); // Consume newline

        System.out.print("Enter Favorite Subject: ");
        String favoriteSubject = sc.nextLine();

        System.out.print("Enter Marks of 5 subjects : ");

        int[] marks = new int[5];
        for (int i = 0; i < marks.length; i++) {
            marks[i] = sc.nextInt();
        }

        student.printDetails(
                rollNo,
                fullName,
                age,
                gender,
                height,
                weight,
                address,
                city,
                state,
                country,
                zip,
                phoneNumber,
                cgpa,
                hosteler,
                favoriteSubject
        );
        sc.close();

        student.calcBMI(height, weight);
        student.scoreDetails(marks);
    }

    void calcBMI(double heightCm, double weightKg) {
        double heightInMeter = heightCm / 100;
        double bmi = weightKg / Math.pow(heightInMeter, 2);
        System.out.println("BMI: " + bmi);
    }

    void scoreDetails(int[] marks) {
        int sum = 0;
        float avg, percent;
        for (int mark : marks) {
            sum += mark;
        }

        avg = (float) sum / marks.length;
        percent = sum / (float) marks.length;

        System.out.println("Total marks: " + sum);
        System.out.println("Total percent: " + percent);
        System.out.println("Marks avg: " + avg);
    }

    void printDetails(int rollNo, String fullName, int age,
                      char gender,
                      double height, double weight,
                      String address, String city, String state, String country,
                      int zip, long phoneNumber,
                      float cgpa,
                      boolean hosteler, String favoriteSubject) {

        System.out.printf("""
                        ========== STUDENT DETAILS ==========
                        Roll No          : %d
                        Full Name        : %s
                        Age              : %d
                        Gender           : %c
                        Height           : %.2f cm
                        Weight           : %.2f kg
                        Address          : %s
                        City             : %s
                        State            : %s
                        Country          : %s
                        Zip Code         : %d
                        Phone Number     : %d
                        CGPA             : %.2f
                        Hosteler        : %b
                        Favorite Subject : %s
                        =====================================
                        """,
                rollNo, fullName, age, gender,
                height, weight,
                address, city, state, country,
                zip, phoneNumber, cgpa,
                hosteler, favoriteSubject);
    }
}
