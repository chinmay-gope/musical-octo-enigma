package com.myproject.introduction;

public class Bank {
    static int accountNumber = 1000;
    String customerName;
    double accountBalance;

    void getBalance() {
        System.out.println("Account balance is " + accountBalance);
    }

    void deposit(double amount) {
        System.out.println("Deposited " + amount + " into account " + accountNumber);
        accountBalance = accountBalance + amount;
        getBalance();
    }

    void withdraw(double amount) {
        System.out.println("Withdraw amount is " + amount);
        if (amount <= accountBalance) {
            accountBalance = accountBalance - amount;
        } else {
            System.out.println("Insufficient funds");
        }
        getBalance();
    }

    public Bank(String customerName, double accountBalance) {
        this.customerName = customerName;
        this.accountBalance = accountBalance;
        accountNumber++;
    }

    void showDetails() {
        System.out.println("___________________________");
        System.out.println("Account Number: " + Bank.accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Balance: " + accountBalance);
        System.out.println("___________________________");
    }


    static void main() {
        Bank bank = new Bank("Jack", 100);

        bank.getBalance();
        bank.deposit(100);
        bank.deposit(200);
        bank.showDetails();
        bank.withdraw(400);
        bank.withdraw(200);

        Bank bank2 = new Bank("Bob", 100);
        bank2.showDetails();

        Bank bank3 = new Bank("John", 100);
        bank3.showDetails();
    }
}
