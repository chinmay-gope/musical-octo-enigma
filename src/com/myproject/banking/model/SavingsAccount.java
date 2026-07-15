package com.myproject.banking.model;

import com.myproject.banking.enums.AccountType;

public class SavingsAccount extends Account {

    private static final double RATE_OF_INTEREST = 3.5;

    public SavingsAccount(long accountNumber, Customer owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * RATE_OF_INTEREST / 100;
    }
}
