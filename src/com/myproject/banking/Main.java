package com.myproject.banking;

import com.myproject.banking.enums.AccountType;
import com.myproject.banking.factory.AccountFactory;
import com.myproject.banking.model.Account;
import com.myproject.banking.model.Customer;
import com.myproject.banking.repository.AccountRepository;

public class Main {
    static void main() {
        Customer customer = new Customer(
                101,
                "Tony Stark",
                "9876543210",
                "tony@gmail.com",
                "New York"
        );

        Account savings =
                AccountFactory.create(
                        AccountType.SAVINGS,
                        customer,
                        5000);

        Account current =
                AccountFactory.create(
                        AccountType.CURRENT,
                        customer,
                        10000);

        AccountRepository repository = new AccountRepository();

        repository.save(savings);
        repository.save(current);

        System.out.println("count : "+ repository.count());
        repository.findAll()
                .forEach(System.out::println);
        System.out.println(repository.findByAccountNumber(savings.getAccountNumber()));
    }
}
