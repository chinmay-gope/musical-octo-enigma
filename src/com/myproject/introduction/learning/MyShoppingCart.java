package com.myproject.introduction.learning;

import java.util.Scanner;

public class MyShoppingCart {

    double calculateBill(double price, int quantity) {
        return price * quantity;
    }

    double calculateGST(double amount) {
        // GST at 18%
        return amount * 0.18;
    }

    double calculateDiscount(double amount, double discount) {
        return amount - (amount * (discount / 100));
    }

    double calculateFinalPrice(double amount, double tax) {
        return amount + tax;
    }

    double getDeliveryCharge(double amount) {
        // Free delivery above 1000
        return amount >= 1000 ? 0 : 50;
    }

    double applyCoupon(double amount, String code) {
        if (code.equalsIgnoreCase("SAVE10")) {
            return calculateDiscount(amount, 10);
        } else if (code.equalsIgnoreCase("SAVE20")) {
            return calculateDiscount(amount, 20);
        }
        return amount; // no coupon applied
    }

    int calculateTotalItems(int... quantities) {
        int total = 0;
        for (int q : quantities) {
            total += q;
        }
        return total;
    }

    int estimateDeliveryDays(String location) {
        if (location.equalsIgnoreCase("Local")) return 2;
        if (location.equalsIgnoreCase("Domestic")) return 5;
        return 10; // International
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        MyShoppingCart cart = new MyShoppingCart();

        // Bill
        System.out.print("Enter item price: ");
        double price = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        double bill = cart.calculateBill(price, qty);
        System.out.println("Bill: " + bill);

        // GST
        double gst = cart.calculateGST(bill);
        System.out.println("GST (18%): " + gst);

        // Discount
        System.out.print("\nEnter discount percentage: ");
        double discount = sc.nextDouble();
        double discounted = cart.calculateDiscount(bill, discount);
        System.out.println("After Discount: " + discounted);

        // Final Price
        double finalPrice = cart.calculateFinalPrice(discounted, gst);
        System.out.println("Final Price (with GST): " + finalPrice);

        // Delivery Charge
        double delivery = cart.getDeliveryCharge(finalPrice);
        System.out.println("Delivery Charge: " + delivery);
        System.out.println("Total Payable: " + (finalPrice + delivery));

        // Coupon
        System.out.print("\nEnter coupon code (SAVE10 / SAVE20): ");
        String code = sc.next();
        double afterCoupon = cart.applyCoupon(finalPrice, code);
        System.out.println("Price after coupon: " + afterCoupon);

        // Total Items
        System.out.println("\nEnter quantities of 3 items: ");
        int q1 = sc.nextInt();
        int q2 = sc.nextInt();
        int q3 = sc.nextInt();
        System.out.println("Total items in cart: " + cart.calculateTotalItems(q1, q2, q3));

        // Delivery Days
        System.out.print("\nEnter delivery location (Local/Domestic/Intl): ");
        String location = sc.next();
        System.out.println("Estimated Delivery Days: " + cart.estimateDeliveryDays(location));

        sc.close();
    }
}
