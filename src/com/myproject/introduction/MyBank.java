package com.myproject.introduction;

import java.util.Scanner;

public class MyBank {

    double calculateBalance(double balance, double deposit) {
        return balance + deposit;
    }

    double withdrawAmount(double balance, double amount) {
        return (amount <= balance) ? balance - amount : balance; // no overdraft
    }

    double calculateInterest(double amount, double rate) {
        return amount * (rate / 100);
    }

    double calculateEMI(double loan, double rate, int months) {
        //  EMI formula
        double monthlyRate = rate / 12 / 100;
        System.out.println("Monthly Rate: " + monthlyRate);
        return (loan * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }

    String getAccountStatus(double balance) {
        System.out.println("Current balance: " + balance);

        if (balance <= 0) return "Inactive / Overdrawn";
        if (balance < 1000) return "Low Balance";
        return "Active";
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        MyBank bank = new MyBank();

        System.out.print("Enter current balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter deposit amount: ");
        double deposit = sc.nextDouble();
        balance = bank.calculateBalance(balance, deposit);
        System.out.println("Updated Balance: " + balance);
        System.out.println("------------------------------------");

        System.out.print("\nEnter withdrawal amount: ");
        double withdraw = sc.nextDouble();
        balance = bank.withdrawAmount(balance, withdraw);
        System.out.println("Balance after withdrawal: " + balance);
        System.out.println("------------------------------------");

        System.out.print("\nEnter amount for interest calculation: ");
        double amount = sc.nextDouble();
        System.out.print("Enter annual interest rate (%): ");
        double rate = sc.nextDouble();
        System.out.println("Interest: " + bank.calculateInterest(amount, rate));
        System.out.println("------------------------------------");

        System.out.print("\nEnter loan amount: ");
        double loan = sc.nextDouble();
        System.out.print("Enter annual interest rate (%): ");
        double loanRate = sc.nextDouble();
        System.out.print("Enter loan duration in months: ");
        int months = sc.nextInt();
        System.out.println("Monthly EMI: " + bank.calculateEMI(loan, loanRate, months));
        System.out.println("------------------------------------");

        System.out.println("\nAccount Status: " + bank.getAccountStatus(balance));

        sc.close();
    }
}
