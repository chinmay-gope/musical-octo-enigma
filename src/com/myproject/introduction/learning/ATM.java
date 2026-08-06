package com.myproject.introduction.learning;

import java.util.Scanner;

public class ATM {
    final int CORRECT_PIN = 6606;
    int pin, amount, currentBalance = 10000;
    int dailyWithdrawLimit = 5000;

    void main() {
        System.out.println("Enter you pin: ");
        Scanner sc = new Scanner(System.in);
        pin = sc.nextInt();

        if (pin == CORRECT_PIN) {
            System.out.println("Enter withdraw amount: ");
            amount = sc.nextInt();

            if (amount <= dailyWithdrawLimit) {

                if (amount <= currentBalance) {
                    currentBalance -= amount;
                    System.out.println("Withdrawal successful!");
                    System.out.println("Remaining Balance: " + currentBalance);
                } else {
                    System.out.println("Insufficient funds. Please try again.");
                }
                System.out.println("your Account current balance is : " + currentBalance);
            } else {
                System.out.println("Amount exceeds daily withdrawal limit.");
            }
        } else {
            System.out.println("Invalid pin");
        }
    }
}
