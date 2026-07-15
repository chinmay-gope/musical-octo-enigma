package com.myproject.banking.services;

import com.myproject.banking.enums.AccountType;
import com.myproject.banking.factory.AccountFactory;
import com.myproject.banking.model.Account;
import com.myproject.banking.model.Customer;
import com.myproject.banking.repository.AccountRepository;

import java.util.List;

public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account createAccount(AccountType type,
                                 Customer owner,
                                 double initialBalance) {
        Account account =
                AccountFactory.create(
                        type,
                        owner,
                        initialBalance);

        repository.save(account);

        return account;
    }

    public Account findAccount(long accountNumber) {
        return repository.findByAccountNumber(accountNumber).orElseThrow();
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public void freezeAccount(long accountNumber) {
        Account account = getAccount(accountNumber);
        account.freeze();

        repository.save(account);
    }

    public void activateAccount(long accountNumber) {
        Account account = getAccount(accountNumber);
        account.activate();

        repository.save(account);
    }

    public void closeAccount(long accountNumber) {
        Account account = getAccount(accountNumber);
        account.close();

        repository.save(account);
    }

    private Account getAccount(long accountNumber) {

        return repository.findByAccountNumber(accountNumber).orElseThrow();
    }
}
