package com.myproject.introduction.accessmodfr2;

import com.myproject.introduction.accessmodfr.Account;

public class Test1 {
    static void main() {
        Account account = new Account(20_000);

        account.deposit(10_000);
        account.checkBalance();

        account.withdraw(1000);
        account.checkBalance();

        account.deposit(-10);
        account.checkBalance();

        account.withdraw(80_000);
        account.checkBalance();

        account.withdraw(-1000);
        account.checkBalance();
    }
}
