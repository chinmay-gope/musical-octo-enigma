package com.myproject.billing;

import java.util.Map;
import java.util.Scanner;

import static com.myproject.billing.RestaurantBill.*;

public class Cart {
    static void addItem(Scanner sc, Map<RestaurantBill.MenuItem, Integer> cart) {

        printMenu();

        System.out.print("Enter item : ");
        String input = sc.nextLine();

        RestaurantBill.MenuItem item = findMenuItem(input);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        System.out.print("Quantity : ");
        int qty = sc.nextInt();
        sc.nextLine();

        if (qty <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        cart.put(item,
                cart.getOrDefault(item, 0) + qty);

        System.out.println("Added Successfully.");
    }

    static void removeItem(Scanner sc, Map<RestaurantBill.MenuItem, Integer> cart) {

        if (cart.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }

        viewCart(cart);

        System.out.print("Enter Item to Remove : ");

        String input = sc.nextLine();

        RestaurantBill.MenuItem item = findMenuItem(input);

        if (item == null || !cart.containsKey(item)) {
            System.out.println("Item not in cart.");
            return;
        }

        cart.remove(item);

        System.out.println("Item Removed.");
    }

    static void updateQuantity(Scanner sc,
                               Map<MenuItem, Integer> cart) {

        if (cart.isEmpty()) {
            System.out.println("Cart Empty.");
            return;
        }

        viewCart(cart);

        System.out.print("Enter Item : ");

        String input = sc.nextLine();

        MenuItem item = findMenuItem(input);

        if (item == null || !cart.containsKey(item)) {
            System.out.println("Item not found.");
            return;
        }

        System.out.print("New Quantity : ");

        int qty = sc.nextInt();
        sc.nextLine();

        if (qty <= 0) {
            cart.remove(item);
            System.out.println("Item Removed.");
        } else {
            cart.put(item, qty);
            System.out.println("Quantity Updated.");
        }
    }

    static void viewCart(Map<MenuItem, Integer> cart) {

        if (cart.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }

        double subtotal = 0;

        System.out.println("\n======= CART =======");

        System.out.printf("%-20s %-10s %-10s%n",
                "Item", "Qty", "Amount");

        printSeparator();

        for (Map.Entry<MenuItem, Integer> entry : cart.entrySet()) {

            MenuItem item = entry.getKey();

            int qty = entry.getValue();

            double amount = item.price * qty;

            subtotal += amount;

            System.out.printf("%-20s %-10d ₹%.2f%n",
                    item.name,
                    qty,
                    amount);
        }

        printSeparator();

        System.out.printf("Subtotal : ₹%.2f%n", subtotal);
    }

    static void clearCart(Scanner sc,
                          Map<MenuItem, Integer> cart) {

        if (cart.isEmpty()) {
            System.out.println("Cart Already Empty.");
            return;
        }

        System.out.print("Clear Cart (Y/N) : ");

        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            cart.clear();
            System.out.println("Cart Cleared.");
        }
    }
}
