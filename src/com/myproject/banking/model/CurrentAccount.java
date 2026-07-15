package com.myproject.banking.model;

import com.myproject.banking.enums.AccountType;

public class CurrentAccount extends Account {

    private static final double RATE_OF_INTEREST = 0.0;

    public CurrentAccount(long accountNumber, Customer owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CURRENT;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * RATE_OF_INTEREST / 100;
    }
}
