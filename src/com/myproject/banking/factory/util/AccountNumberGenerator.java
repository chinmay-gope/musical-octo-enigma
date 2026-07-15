package com.myproject.banking.factory.util;

public final class AccountNumberGenerator {
    private static long nextAccountNumber = 100000001L;

    private AccountNumberGenerator() {
    }

    public static long generate() {
        return nextAccountNumber++;
    }
}
