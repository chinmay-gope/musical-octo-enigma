package com.myproject.billing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static com.myproject.billing.BillGenerator.*;
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
        MENU.put("7", new MenuItem("Ice Cream", 90));
        MENU.put("8", new MenuItem("Chicken Wings", 220));
        MENU.put("9", new MenuItem("Veg Biryani", 200));
        MENU.put("10", new MenuItem("Paneer Tikka", 180));
        MENU.put("11", new MenuItem("Chocolate Cake", 150));
        MENU.put("12", new MenuItem("Coffee", 70));
        MENU.put("13", new MenuItem("Tea", 40));
        MENU.put("14", new MenuItem("Milkshake", 120));
        MENU.put("15", new MenuItem("Garlic Bread", 110));
        MENU.put("16", new MenuItem("Nachos", 130));
        MENU.put("17", new MenuItem("Spring Rolls", 140));
        MENU.put("18", new MenuItem("Grilled Sandwich", 160));
        MENU.put("19", new MenuItem("Soup", 100));
        MENU.put("20", new MenuItem("Donut", 60));
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

}
