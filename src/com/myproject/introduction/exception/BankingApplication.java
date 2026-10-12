package com.myproject.introduction.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingApplication {

    private final Map<Integer, Account> accounts = new HashMap<>();

    static void main() {

        BankingApplication bank = new BankingApplication();

        bank.addAccount(new Account(101, 50000));
        bank.addAccount(new Account(102, 20000));
        bank.addAccount(new Account(103, 10000));

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter sender account number: ");
            int sender = sc.nextInt();

            System.out.print("Enter receiver account number: ");
            int receiver = sc.nextInt();

            System.out.print("Enter transfer amount: ");
            double amount = sc.nextDouble();

            bank.transfer(sender, receiver, amount);

            System.out.println("\nTransaction successful!");
            System.out.println("Amount transferred : " + amount);
            System.out.println("From account       : " + sender);
            System.out.println("To account         : " + receiver);

        } catch (AccountNotFoundException |
                 InsufficientBalanceException |
                 InvalidAmountException e) {

            System.out.println("\nTransaction failed!");
            System.out.println("Reason: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("\nInvalid input!");
            System.out.println("Reason: " + e.getMessage());
        }
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void transfer(int senderNumber, int receiverNumber, double amount)
            throws AccountNotFoundException,
            InsufficientBalanceException,
            InvalidAmountException {

        validateAmount(amount);

        Account sender = getAccount(senderNumber);
        Account receiver = getAccount(receiverNumber);

        if (senderNumber == receiverNumber) {
            throw new InvalidAmountException(
                    "Sender and receiver accounts cannot be the same."
            );
        }

        if (sender.getBalance() < amount) {
            throw new InsufficientBalanceException(
                    "Insufficient balance. Available balance: "
                            + sender.getBalance()
            );
        }

        sender.withdraw(amount);
        receiver.deposit(amount);
    }

    private void validateAmount(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Transfer amount must be greater than zero."
            );
        }
    }

    private Account getAccount(int accountNumber)
            throws AccountNotFoundException {

        Account account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Account not found: " + accountNumber
            );
        }

        return account;
    }
}
