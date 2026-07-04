package com.myproject.introduction;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

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
            printMenu();
            System.out.print("Enter your choice (number or item name): ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase(
                    String.valueOf(MENU.size() + 1)  // 6 : exit
            ) || input.equalsIgnoreCase("exit")) {
                printFinalBill(cart);
                sc.close();
                break;
            }

            MenuItem item = findMenuItem(input);

            if (item != null) {
                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine(); // consume newline
                cart.put(item, cart.getOrDefault(item, 0) + quantity);
                System.out.println(quantity + " " + item.name + "(s) added to cart.");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n====== RESTAURANT MENU ======");
        MENU.forEach((key, item) ->
                System.out.printf("%s. %-19s - ₹%d%n", key, item.name, item.price)
        );
        System.out.println(MENU.size() + 1 + ". Generate Bill & Exit");
    }

    private static MenuItem findMenuItem(String input) {
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

        System.out.println("-----------------------------------------------");

        // Subtotal
        System.out.printf("%-20s %-8s ₹%9.2f%n", "Subtotal", "", subtotal);

        // GST and Service Charge
        double gst = subtotal * GST_CHARGE_COST;           // 5% GST
        double serviceCharge = subtotal * SERVICE_CHARGE_COST; // 10% Service Charge

        double total = subtotal + gst + serviceCharge;

        System.out.printf("%-20s %-8s ₹%9.2f%n", "GST (5%)", "", gst);
        System.out.printf("%-20s %-8s ₹%9.2f%n", "Service Charge (10%)", "", serviceCharge);

        System.out.println("-----------------------------------------------");

        // Total
        System.out.printf("%-20s %-8s ₹%9.2f%n", "TOTAL", "", total);

        System.out.println("\nThank you! Visit Again.");
    }


    private static class MenuItem {
        String name;
        int price;

        MenuItem(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
}
