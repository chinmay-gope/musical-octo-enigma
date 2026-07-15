package com.myproject.banking.repository;

import com.myproject.banking.model.Account;

import java.util.*;

public class AccountRepository {

    private final Map<Long, Account> accounts;

    public AccountRepository() {
        accounts = new HashMap<>();
    }

    public void save(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Optional<Account> findByAccountNumber(long accountNumber) {
        return Optional.ofNullable(accounts.get(accountNumber));
    }

    public boolean exists(long accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public void delete(long accountNumber) {
        accounts.remove(accountNumber);
    }

    public List<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }

    public int count() {
        return accounts.size();
    }

    public void clear() {
        accounts.clear();
    }
}
