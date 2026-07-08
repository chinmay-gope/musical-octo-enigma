package com.myproject.introduction;

import java.util.Scanner;

public class MyConverter {

    // Temperature conversions
    double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    // Distance conversions
    double kmToMiles(double km) {
        return km * 0.621371;
    }

    double milesToKm(double miles) {
        return miles / 0.621371;
    }

    // Weight conversions
    double kgToPounds(double kg) {
        return kg * 2.20462;
    }

    double poundsToKg(double pounds) {
        return pounds / 2.20462;
    }

    // Metrics conversions
    double cmToInches(double cm) {
        return cm / 2.54;
    }

    double inchesToCm(double inches) {
        return inches * 2.54;
    }

    double litersToGallons(double liters) {
        return liters * 0.264172;
    }

    double gallonsToLiters(double gallons) {
        return gallons / 0.264172;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        MyConverter conv = new MyConverter();

        // Temperature
        System.out.print("Enter Celsius: ");
        double c = sc.nextDouble();
        System.out.println("Fahrenheit: " + conv.celsiusToFahrenheit(c));

        System.out.print("\nEnter Fahrenheit: ");
        double f = sc.nextDouble();
        System.out.println("Celsius: " + conv.fahrenheitToCelsius(f));

        // Distance
        System.out.print("\nEnter kilometers: ");
        double km = sc.nextDouble();
        System.out.println("Miles: " + conv.kmToMiles(km));

        System.out.print("\nEnter miles: ");
        double miles = sc.nextDouble();
        System.out.println("Kilometers: " + conv.milesToKm(miles));

        // Weight
        System.out.print("\nEnter kilograms: ");
        double kg = sc.nextDouble();
        System.out.println("Pounds: " + conv.kgToPounds(kg));

        System.out.print("\nEnter pounds: ");
        double pounds = sc.nextDouble();
        System.out.println("Kilograms: " + conv.poundsToKg(pounds));

        // Metric conversions
        System.out.print("\nEnter centimeters: ");
        double cm = sc.nextDouble();
        System.out.println("Inches: " + conv.cmToInches(cm));

        System.out.print("\nEnter inches: ");
        double inches = sc.nextDouble();
        System.out.println("Centimeters: " + conv.inchesToCm(inches));

        System.out.print("\nEnter liters: ");
        double liters = sc.nextDouble();
        System.out.println("Gallons: " + conv.litersToGallons(liters));

        System.out.print("\nEnter gallons: ");
        double gallons = sc.nextDouble();
        System.out.println("Liters: " + conv.gallonsToLiters(gallons));
    }
}
