package com.myproject.billing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static com.myproject.billing.Cart.*;

public class RestaurantBill {

    public static final double GST_CHARGE_COST = 0.05;
    public static final double SERVICE_CHARGE_COST = 0.10;
    private static final Map<String, MenuItem> MENU = new LinkedHashMap<>();

    static {
        MENU.put("1", new MenuItem("Burger", 120));
        MENU.put("2", new MenuItem("Pizza", 250));
        MENU.put("3", new MenuItem("Sandwich", 100));
        MENU.put("4", new MenuItem("Pasta", 180));
        MENU.put("5", new MenuItem("Cold Drink", 50));
        MENU.put("6", new MenuItem("French Fries", 80));
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        Map<MenuItem, Integer> cart = new LinkedHashMap<>();

        while (true) {

            System.out.println("""
                    1. Add Item
                    2. Remove Item
                    3. Update Quantity
                    4. View Cart
                    5. Clear Cart
                    6. Generate Bill & Exit
                    """);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addItem(sc, cart);

                case 2 -> removeItem(sc, cart);

                case 3 -> updateQuantity(sc, cart);

                case 4 -> viewCart(cart);

                case 5 -> clearCart(sc, cart);

                case 6 -> {
                    printFinalBill(cart);
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid Choice");
            }

        }
    }

    static void printMenu() {
        System.out.println("\n====== RESTAURANT MENU ======");
        MENU.forEach((key, item) ->
                System.out.printf("%s. %-19s - ₹%d%n", key, item.name, item.price));
        System.out.println(MENU.size() + 1 + ". Generate Bill & Exit");
    }

    static MenuItem findMenuItem(String input) {
        if (MENU.containsKey(input)) {
            return MENU.get(input);
        }
        for (MenuItem item : MENU.values()) {
            if (item.name.equalsIgnoreCase(input)) {
                return item;
            }
        }
        return null;
    }

    private static void printFinalBill(Map<MenuItem, Integer> cart) {
        System.out.println("\n========== FINAL BILL ==========");
        double subtotal = 0;

        // Header
        System.out.printf("%-20s %-8s %10s%n", "Item", "Qty", "Amount");
        System.out.println("-----------------------------------------------");

        // Items
        for (Map.Entry<MenuItem, Integer> entry : cart.entrySet()) {
            MenuItem item = entry.getKey();
            int qty = entry.getValue();
            double amount = item.price * qty;
            subtotal += amount;
            System.out.printf("%-20s %-8d ₹%9.2f%n", item.name, qty, amount);
        }

        printSeparator();

        // Subtotal
        System.out.printf("%-20s %-8s ₹%9.2f%n", "Subtotal", "", subtotal);

        // GST and Service Charge
        double gst = subtotal * GST_CHARGE_COST;           // 5% GST
        double serviceCharge = subtotal * SERVICE_CHARGE_COST; // 10% Service Charge

        double total = subtotal + gst + serviceCharge;

        System.out.printf("%-20s %-8s ₹%9.2f%n", "GST (5%)", "", gst);
        System.out.printf("%-20s %-8s ₹%9.2f%n", "Service Charge (10%)", "", serviceCharge);

        printSeparator();

        // Total
        System.out.printf("%-20s %-8s ₹%9.2f%n", "TOTAL", "", total);

        System.out.println("\nThank you! Visit Again.");
    }

    static void printSeparator() {
        System.out.println("-----------------------------------------------");
    }

    public static class MenuItem {
        String name;
        int price;

        MenuItem(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
}
