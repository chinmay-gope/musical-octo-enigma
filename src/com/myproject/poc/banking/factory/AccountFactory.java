package com.myproject.poc.banking.factory;

import com.myproject.poc.banking.enums.AccountType;
import com.myproject.poc.banking.factory.util.AccountNumberGenerator;
import com.myproject.poc.banking.model.*;

public final class AccountFactory {

    private AccountFactory() {
    }

    public static Account create(AccountType type,
                                 Customer owner,
                                 double initialBalance) {
        long accountNumber =
                AccountNumberGenerator.generate();

        return switch (type) {

            case SAVINGS -> new SavingsAccount(
                    accountNumber,
                    owner,
                    initialBalance);

            case CURRENT -> new CurrentAccount(
                    accountNumber,
                    owner,
                    initialBalance);

            case FIXED_DEPOSIT -> new FixedDepositAccount(
                    accountNumber,
                    owner,
                    initialBalance);

            case null, default -> throw new IllegalArgumentException("Unknown account type.");
        };
    }
}
