package com.myproject.introduction;

import java.util.Scanner;

public class RestaurantBill {

    void main() {

        Scanner sc = new Scanner(System.in);

        int choice;
        int quantity;
        double totalBill = 0;

        while (true) {

            System.out.println("\n====== RESTAURANT MENU ======");
            System.out.println("1. Burger      - ₹120");
            System.out.println("2. Pizza       - ₹250");
            System.out.println("3. Sandwich    - ₹100");
            System.out.println("4. Pasta       - ₹180");
            System.out.println("5. Cold Drink  - ₹50");
            System.out.println("6. Generate Bill & Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    totalBill += quantity * 120;
                    System.out.println(quantity + " Burger(s) added to cart.");
                    break;

                case 2:
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    totalBill += quantity * 250;
                    System.out.println(quantity + " Pizza(s) added to cart.");
                    break;

                case 3:
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    totalBill += quantity * 100;
                    System.out.println(quantity + " Sandwich(es) added to cart.");
                    break;

                case 4:
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    totalBill += quantity * 180;
                    System.out.println(quantity + " Pasta(s) added to cart.");
                    break;

                case 5:
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    totalBill += quantity * 50;
                    System.out.println(quantity + " Cold Drink(s) added to cart.");
                    break;

                case 6:
                    System.out.println("\n========== FINAL BILL ==========");
                    System.out.println("Total Amount : ₹" + totalBill);
                    System.out.println("Thank you! Visit Again.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}