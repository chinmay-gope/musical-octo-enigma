package com.myproject.introduction;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestaurantBill {

    private static final Map<Integer, MenuItem> MENU = new HashMap<>();

    static {
        MENU.put(1, new MenuItem("Burger", 120));
        MENU.put(2, new MenuItem("Pizza", 250));
        MENU.put(3, new MenuItem("Sandwich", 100));
        MENU.put(4, new MenuItem("Pasta", 180));
        MENU.put(5, new MenuItem("Cold Drink", 50));
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        double totalBill = 0;

        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 6) {
                System.out.println("\n========== FINAL BILL ==========");
                System.out.printf("Total Amount : Rs %.2f%n", totalBill);
                System.out.println("Thank you! Visit Again.");
                sc.close();
                break;
            }

            MenuItem item = MENU.get(choice);
            if (item != null) {
                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();
                totalBill += item.price * quantity;
                System.out.println(quantity + " " + item.name + "(s) added to cart.");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n====== RESTAURANT MENU ======");
        MENU.forEach((key, item) ->
                System.out.printf("%d. %-10s - ₹%d%n", key, item.name, item.price)
        );
        System.out.println("6. Generate Bill & Exit");
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
