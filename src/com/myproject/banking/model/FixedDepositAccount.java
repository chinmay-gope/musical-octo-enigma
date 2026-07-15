package com.myproject.banking.model;

import com.myproject.banking.enums.AccountType;

public class FixedDepositAccount extends Account {

    private static final double RATE_OF_INTEREST = 7.25;

    public FixedDepositAccount(long accountNumber, Customer owner, double initialBalance) {
        super(accountNumber, owner, initialBalance);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.FIXED_DEPOSIT;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * RATE_OF_INTEREST / 100;
    }
}
