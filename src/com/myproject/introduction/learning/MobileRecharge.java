package com.myproject.introduction.learning;

import java.util.Scanner;

public class MobileRecharge {
    static void main(String[] args) {
        final int VALID_PLAN = 199;
        double walletBalance = 500.0;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter recharge plan amount: ");
        int planAmount = sc.nextInt();

        if (planAmount == VALID_PLAN) {

            if (walletBalance >= planAmount) {
                walletBalance -= planAmount;
                System.out.println("Recharge successful!");
                System.out.println("Remaining Balance: " + walletBalance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid recharge plan.");
        }

        sc.close();
    }
}
