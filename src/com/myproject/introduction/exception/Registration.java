package com.myproject.introduction.exception;

import java.util.Scanner;

public class Registration {
    static void main() {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter your age: ");
            int age = sc.nextByte();

            if (age < 18) {
                throw new InvalidAgeException("Age must be grater than 18.");
            } else {
                System.out.println("Registration Successful");
            }

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }

        sc.nextLine(); //consume new line
        try (sc) {

            System.out.println("Enter your password: ");
            String password = sc.next();

            if (password.length() < 8) {
                throw new InvalidAgeException("password must be grater than 8 characters.");
            } else {
                System.out.println("Registration Successful");
            }

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }
}
