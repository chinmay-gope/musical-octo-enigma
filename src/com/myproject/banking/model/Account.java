package com.myproject.banking.model;

import com.myproject.banking.enums.AccountStatus;
import com.myproject.banking.enums.AccountType;
import com.myproject.banking.transaction.Transaction;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Account {

    private final long accountNumber;
    private final Customer owner;

    private double balance;

    private final LocalDateTime createdAt;

    private AccountStatus status;

    private final List<Transaction> transactions;

    protected Account(long accountNumber,
                      Customer owner,
                      double initialBalance) {

        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null.");
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;

        this.createdAt = LocalDateTime.now();

        this.status = AccountStatus.ACTIVE;

        this.transactions = new ArrayList<>();
    }

    // -------------------------
    // Business Operations
    // -------------------------

    public void deposit(double amount) {

        validateActiveAccount();

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be greater than zero.");
        }

        balance += amount;
    }

    public void withdraw(double amount) {

        validateActiveAccount();

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                    "Insufficient balance.");
        }

        balance -= amount;
    }

    // -------------------------
    // Account State
    // -------------------------

    public void freeze() {
        status = AccountStatus.FROZEN;
    }

    public void activate() {
        status = AccountStatus.ACTIVE;
    }

    public void close() {
        status = AccountStatus.CLOSED;
    }

    private void validateActiveAccount() {

        if (status != AccountStatus.ACTIVE) {
            throw new IllegalStateException(
                    "Account is not active.");
        }
    }

    // -------------------------
    // Transactions
    // -------------------------

    protected void addTransaction(Transaction transaction) {

        if (transaction != null) {
            transactions.add(transaction);
        }
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    // -------------------------
    // Getters
    // -------------------------

    public long getAccountNumber() {
        return accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public AccountStatus getStatus() {
        return status;
    }

    // -------------------------
    // Abstract Methods
    // -------------------------

    public abstract AccountType getAccountType();

    public abstract double calculateInterest();

    @Override
    public String toString() {

        return """
                ==============================
                Account Number : %d
                Owner          : %s
                Type           : %s
                Balance        : %.2f
                Status         : %s
                Created At     : %s
                ==============================
                """
                .formatted(
                        accountNumber,
                        owner.name(),
                        getAccountType(),
                        balance,
                        status,
                        createdAt
                );
    }

}
