package com.myproject.billing;

import java.nio.file.Files;
import java.nio.file.Path;
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
                System.out.printf("%s. %-19s - ₹%d%n", key, item.name(), item.price()));
        System.out.println(MENU.size() + 1 + ". Generate Bill & Exit");
    }

    static MenuItem findMenuItem(String input) {
        if (MENU.containsKey(input)) {
            return MENU.get(input);
        }
        for (MenuItem item : MENU.values()) {
            if (item.name().equalsIgnoreCase(input)) {
                return item;
            }
        }
        return null;
    }

    static void printSeparator() {
        System.out.println("---------------------------------------");
    }

    // A simple record to hold bill totals
    record BillSummary(double subtotal, double gst, double serviceCharge, double total) {
    }

    private static String buildBillString(Map<MenuItem, Integer> cart, BillSummary summary) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n========== FINAL BILL ==========\n");
        sb.append(String.format("%-20s %-8s %10s%n", "Item", "Qty", "Amount"));
        sb.append("-----------------------------------------------\n");

        for (Map.Entry<MenuItem, Integer> entry : cart.entrySet()) {
            MenuItem item = entry.getKey();
            int qty = entry.getValue();
            double amount = item.price() * qty;
            sb.append(String.format("%-20s %-8d ₹%9.2f%n", item.name(), qty, amount));
        }

        sb.append("-----------------------------------------------\n");
        sb.append(String.format("%-20s %-8s ₹%9.2f%n", "Subtotal", "", summary.subtotal()));
        sb.append(String.format("%-20s %-8s ₹%9.2f%n", "GST (5%)", "", summary.gst()));
        sb.append(String.format("%-20s %-8s ₹%9.2f%n", "Service Charge (10%)", "", summary.serviceCharge()));
        sb.append("-----------------------------------------------\n");
        sb.append(String.format("%-20s %-8s ₹%9.2f%n", "TOTAL", "", summary.total()));
        sb.append("\nThank you! Visit Again.\n");

        return sb.toString();
    }

    // Main orchestration
    private static void printFinalBill(Map<MenuItem, Integer> cart) {
        double subtotal = cart.entrySet()
                .stream()
                .mapToDouble(e -> e.getKey().price() * e.getValue())
                .sum();

        BillSummary summary = new BillSummary(
                subtotal,
                subtotal * GST_CHARGE_COST,
                subtotal * SERVICE_CHARGE_COST,
                subtotal + subtotal * GST_CHARGE_COST + subtotal * SERVICE_CHARGE_COST
        );

        String bill = buildBillString(cart, summary);

        System.out.println(bill);
        writeBillToTextFile(bill);
        writeBillToJson(cart, summary);
    }

    // JSON writer now consumes BillSummary
    private static void writeBillToJson(Map<MenuItem, Integer> cart, BillSummary summary) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{\n");

            sb.append("  \"items\": [\n");
            int i = 0;
            for (var entry : cart.entrySet()) {
                MenuItem item = entry.getKey();
                int qty = entry.getValue();
                double amount = item.price() * qty;

                sb.append("    {\n");
                sb.append("      \"name\": \"").append(item.name()).append("\",\n");
                sb.append("      \"price\": ").append(item.price()).append(",\n");
                sb.append("      \"quantity\": ").append(qty).append(",\n");
                sb.append("      \"amount\": ").append(amount).append("\n");
                sb.append("    }");

                if (++i < cart.size()) sb.append(",");
                sb.append("\n");
            }
            sb.append("  ],\n");

            sb.append("  \"subtotal\": ").append(summary.subtotal()).append(",\n");
            sb.append("  \"gst\": ").append(summary.gst()).append(",\n");
            sb.append("  \"serviceCharge\": ").append(summary.serviceCharge()).append(",\n");
            sb.append("  \"total\": ").append(summary.total()).append("\n");

            sb.append("}\n");

            Path path = Path.of("final_bill.json");
            Files.writeString(path, sb.toString());

            System.out.println("Bill saved to " + path.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error writing JSON bill: " + e.getMessage());
        }
    }

    private static void writeBillToTextFile(String bill) {
        try {
            Path path = Path.of("final_bill.txt");
            Files.writeString(path, bill);
            System.out.println("Bill saved to " + path.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error writing bill: " + e.getMessage());
        }
    }

}
