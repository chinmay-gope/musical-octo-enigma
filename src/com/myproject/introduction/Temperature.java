package com.myproject.introduction;

import java.util.Scanner;

public class Temperature {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Temperature in Celsius:");
        float celsius = sc.nextFloat();

        System.out.print("Enter Temperature in Fahrenheit:");
        float fahrenheit = sc.nextFloat();

        sc.close();

        cToF(celsius);
        fToC(fahrenheit);
        inKelvin(celsius);
    }

    static void fToC(float f) {
        var c = (f - 32) * 5 / 9;
        System.out.println(f + " F in Celsius = " + c);
    }

    static void cToF(float c) {
        var f = (c * 9 / 5) + 32;
        System.out.println(c + " C in Fahrenheit = " + f);
    }

    static void inKelvin(float c) {
        System.out.println("in Kelvin = " + (c + 273.15));
    }

    static class Book {
        static void main() {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter ISBN: ");
            long isbn = sc.nextLong();
            sc.nextLine();

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.printf("""
                    ===== BOOK DETAILS =====
                    ISBN   : %d
                    Title  : %s
                    Author : %s
                    Price  : %.2f
                    ========================
                    """, isbn, title, author, price);

            calcDiscount(price);
        }

        static void calcDiscount(double price) {
            double discounted = price * 0.85; // 15% discount
            double gst = price * 0.05;        // 5% GST
            double finalPrice = discounted + gst;

            System.out.println("Calculations");
            System.out.println("Original Price = " + price);
            System.out.println("Discounted Price = " + discounted);
            System.out.println("GST = " + gst);
            System.out.println("Final Price = " + finalPrice);
        }
    }

    static class Car {
        static void main() {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Car Model: ");
            String model = sc.nextLine();

            System.out.print("Enter Manufacturer: ");
            String manufacturer = sc.nextLine();

            System.out.print("Enter Year: ");
            int year = sc.nextInt();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.printf("""
                    ===== CAR DETAILS =====
                    Model       : %s
                    Manufacturer: %s
                    Year        : %d
                    Price       : %.2f
                    =======================
                    """, model, manufacturer, year, price);

            priceAnalysis(price, year);
        }

        static void priceAnalysis(double price, int year) {
            int sage = 2026 - year;
            double depreciation = price - (sage * 5000);
            double resaleValue = depreciation * 0.80; // assume 20% dealer margin

            System.out.printf("""
                    Age (years)     : %d
                    Current Value   : %.2f
                    Resale Value    : %.2f
                    """, sage, depreciation, resaleValue);
        }
    }

    static class Teacher {
        static void main() {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Teacher ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Subject: ");
            String subject = sc.nextLine();

            System.out.print("Enter Experience (years): ");
            int exp = sc.nextInt();

            System.out.printf("""
                    ===== TEACHER DETAILS =====
                    ID       : %d
                    Name     : %s
                    Subject  : %s
                    Experience: %d years
                    ===========================
                    """, id, name, subject, exp);

            experienceAnalysis(exp);
        }

        static void experienceAnalysis(int exp) {
            int retirementAge = 60;
            int currentAge = 25 + exp;
            int yearsLeft = retirementAge - currentAge;
            double studentsTaught = exp * 30; // assume 30 students per year

            System.out.printf("""
                    --- Calculations ---
                    Current Age       : %d
                    Years to Retire   : %d
                    Students Taught   : %.0f
                    """, currentAge, yearsLeft, studentsTaught);
        }
    }

    static class Patient {
        static void main() {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int sage = sc.nextInt();

            System.out.print("Enter Blood Group: ");
            String bloodGroup = sc.next();

            System.out.printf("""
                    ===== PATIENT DETAILS =====
                    ID         : %d
                    Name       : %s
                    Age        : %d
                    Blood Group: %s
                    ===========================
                    """, id, name, sage, bloodGroup);
        }
    }

    static class Course {
        static void main() {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Course Code: ");
            String code = sc.nextLine();

            System.out.print("Enter Course Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Credits: ");
            int credits = sc.nextInt();

            System.out.printf("""
                    ===== COURSE DETAILS =====
                    Code   : %s
                    Name   : %s
                    Credits: %d
                    ==========================
                    """, code, name, credits);
        }
    }
}