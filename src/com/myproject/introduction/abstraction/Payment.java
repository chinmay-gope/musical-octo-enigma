package com.myproject.introduction.abstraction;

public interface Payment {

    static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    default void printReceipt() {
//        logPayment("Receipt");
//        System.out.println("Payment successful!");
        printLog("Receipt", "Payment successful!");
    }

    default void printTransaction() {
//        logPayment("Transaction");
//        System.out.println("Transaction successful!");
        printLog("Transaction", "Transaction successful!");
    }

    private void printLog(String logType, String message) {
        logPayment(logType);
        System.out.println(message);
    }

    private void logPayment(String type) {
        System.out.println("Logging payment: " + type);
    }

    void pay(double amount);
}
