package com.myproject.banking.bank;

public class Bank {
    private static final Bank INSTANCE = new Bank();

    private Bank() {
    }

    public static Bank getInstance() {
        return INSTANCE;
    }
}
