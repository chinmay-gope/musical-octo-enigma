package com.myproject.introduction;

import java.util.Scanner;

public class ATMSystem {
    final int CORRECT_PIN = 6606;
    final int DAILY_LIMIT = 10000;
    final int MAX_VIEWS = 2;

    double accountBalance = 20000.0;
    int viewCount;

    boolean verifyPin(int pin) {
        return pin == CORRECT_PIN;
    }

    void showMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Exit");
        System.out.print("enter your choice: ");
    }

    void viewBalance() {
        if (viewCount < MAX_VIEWS) {
            viewCount++;
            System.out.println("Your Balance: " + accountBalance);
            System.out.println("You have viewed your account " + viewCount + " time(s) today.");
        } else {
            System.out.println("View limit reached. You can only view balance twice per day.");
        }
    }

    void withdraw(double amount) {
        if (amount < DAILY_LIMIT) {
            if (amount <= accountBalance) {
                accountBalance = accountBalance - amount;
                System.out.println("Withdrawal succeeded.");
                System.out.println("Your Balance: " + accountBalance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Amount exceeds daily withdrawal limit.");
        }
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        ATMSystem atm = new ATMSystem();

        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (atm.verifyPin(enteredPin)) {

            boolean flag = true;

            while (flag) {
                atm.showMenu();
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> atm.viewBalance();

                    case 2 -> {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = sc.nextDouble();
                        atm.withdraw(amount);
                    }

                    case 3 -> {
                        System.out.println("Thank you visit again !");
                        flag = false;
                    }

                    default -> System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid PIN.");
        }

        sc.close();
    }
}
