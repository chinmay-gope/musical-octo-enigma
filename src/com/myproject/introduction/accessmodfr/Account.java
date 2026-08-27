package com.myproject.introduction.accessmodfr;

public class Account {

    public double amount;
    private double currentBalance;

    public Account(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void deposit(int balance) {
        if (balance > 0) {
            currentBalance += balance;
//            System.out.println("currentBalance = " + currentBalance);
        } else {
            System.err.println("Deposit amount cannot be less than 0.");
        }
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            System.err.println("Withdraw amount must be positive.");
            return;
        }

        if (amount <= currentBalance) {
            currentBalance -= amount;
//            System.out.println("currentBalance = " + currentBalance);
        } else {
            System.err.println("Insufficient Balance !");
            System.err.println("Your currentBalance is " + currentBalance);
        }
    }

    public void checkBalance() {
        System.out.println("Your currentBalance is " + currentBalance);
    }
}
