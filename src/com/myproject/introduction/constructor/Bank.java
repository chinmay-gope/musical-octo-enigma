package com.myproject.introduction.constructor;

import java.util.logging.Logger;

public class Bank {
    double balance;
    int accountNumber;
    String accountHolderName;
    private static final Logger LOGGER =
            Logger.getLogger(Bank.class.getName());

    Bank(int accountNumber, String accountHolderName, double balance) {
        if (accountHolderName == null || accountHolderName.isBlank())
            throw new IllegalArgumentException("Invalid account holder name");

        if (balance < 0)
            throw new IllegalArgumentException("Invalid balance");

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    Bank(Bank bank) {
        this(bank.accountNumber, bank.accountHolderName, bank.balance);
    }

    Bank(Bank bank, double newBalance) {
        this(bank.accountNumber, bank.accountHolderName, newBalance);
    }

    void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");

        if (amount > balance) {
            LOGGER.warning("Insufficient balance");
            return;
        }

        balance -= amount;
        LOGGER.info(amount + " withdrawn from " + this.accountNumber);
    }

    void transfer(Bank other, double amount) {
        if (other == null)
            throw new IllegalArgumentException("Destination account cannot be null");

        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");

        if (amount > balance)
            throw new IllegalArgumentException("Insufficient balance");

        withdraw(amount);
        other.deposit(amount);

        LOGGER.info(() -> "Transferred " + amount +
                " from " + accountHolderName +
                " to " + other.accountHolderName);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }

    static void main() {
        Bank sbi = new Bank(1001, "SBI User", 5000);
        System.out.println(sbi);

        Bank b2 = new Bank(sbi);
        b2.deposit(3000);
        System.out.println(b2);
        b2.withdraw(2000);
        System.out.println(b2);

        Bank b3 = new Bank(b2, 4000);
        b3.deposit(1000);
        System.out.println(b3);

        b3.withdraw(6000);
        System.out.println(b3);

        Bank axis = new Bank(1002, "Axis User", 5000);
        axis.deposit(2000);
        System.out.println(axis);

        axis.transfer(sbi, 1);
        axis.transfer(sbi, 99);
        System.out.println("-----------------------");
        System.out.println(axis);
        System.out.println(sbi);
    }
}
