package com.myproject.introduction.abstraction.impl;

import com.myproject.introduction.abstraction.Payment;

class UPI implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }

    @Override
    public void printReceipt() {
        System.out.println("UPI receipt generated");
    }
}

class CreditCard implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

public class PaymentService {
    static void main() {
        Payment upi = new UPI();
        Payment creditCard = new CreditCard();

        double amount = 500;

        if (Payment.isValidAmount(amount)) {

            upi.pay(amount);
            upi.printReceipt(); //  calls @Override method

            System.out.println();

            creditCard.pay(amount);
            creditCard.printReceipt(); // calls Payment's default method

            System.out.println();

            creditCard.printTransaction();
        }
    }
}
