package com.myproject.introduction.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentPortal {
    static final Scanner sc = new Scanner(System.in);
    byte age;
    double avg;
    String name;
    int[] marks = {85, 90, 78};

    static void main() {
        StudentPortal portal = new StudentPortal();

        // 1. NullPointerException
        try {
            portal.name = null;
            System.out.println("Length of name: " + portal.name.length());
        } catch (NullPointerException ex) {
            System.out.println("Caught NullPointerException : Name is null!");
        }

        // 2. InputMismatchException
        portal.takeAge();

        // 3. ArithmeticException
        try {
            portal.avg = 250 / 0;
            System.out.println("Average Marks: " + portal.avg);
        } catch (ArithmeticException ex) {
            System.out.println("Caught ArithmeticException : Division by zero!");
        }

        // 4. ArrayIndexOutOfBoundsException
        try (sc) {
            System.out.print("Enter index to access marks: ");
            int index = sc.nextInt();
            System.out.println("Marks at index " + index + ": " + portal.marks[index]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Caught ArrayIndexOutOfBoundsException : Invalid index!");
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input for index!");
        }
    }

    public void takeAge() {
        while (true) {
            try {
                System.out.print("Enter your age: ");
                age = sc.nextByte();

                if (age <= 0 || age > 100) {
                    System.out.println("Invalid age, must be between 1 and 100.");
                    continue;
                }
                break; // valid input
            } catch (InputMismatchException ex) {
                System.out.println("Caught InputMismatchException : Enter a valid integer!");
                sc.nextLine(); // clear invalid input
            }
        }
        System.out.println("Your age is: " + age);
    }
}
