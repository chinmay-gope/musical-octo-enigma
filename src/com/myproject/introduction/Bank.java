package com.myproject.introduction;

public class Bank {
    static int accountNumber = 1000;
    String customerName;
    double accountBalance;

    {
        accountNumber++;
    }

    public Bank(String customerName, double accountBalance) {
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }

    void showDetails() {
        System.out.println("Account Number: " + Bank.accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Balance: " + accountBalance);
        System.out.println("___________________________");
    }


    static void main() {
        Bank bank = new Bank("Jack", 100);
        bank.showDetails();

        Bank bank2 = new Bank("John", 350);
        bank2.showDetails();

        Bank bank3 = new Bank("Tony", 400);
        bank3.showDetails();
    }
}
