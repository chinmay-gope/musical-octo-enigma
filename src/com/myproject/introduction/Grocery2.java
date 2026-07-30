package com.myproject.introduction;

import java.util.Map;
import java.util.Scanner;

public class Grocery2 {
    static void main() {
        System.out.println("Welcome to Grocery store");
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> vegPrices = Map.ofEntries(
                Map.entry("tmt", 20), Map.entry("ptt", 10), Map.entry("bjl", 10),
                Map.entry("oni", 15), Map.entry("car", 25), Map.entry("cab", 30),
                Map.entry("cap", 40), Map.entry("cuc", 20), Map.entry("pea", 50),
                Map.entry("cor", 35), Map.entry("spi", 20), Map.entry("cau", 45),
                Map.entry("bea", 30)
        );

        Map<String, Integer> fruitPrices = Map.ofEntries(
                Map.entry("mng", 50), Map.entry("app", 30), Map.entry("grp", 40),
                Map.entry("ban", 20), Map.entry("org", 35), Map.entry("wat", 60),
                Map.entry("pap", 45), Map.entry("pna", 55), Map.entry("guv", 30),
                Map.entry("pom", 80), Map.entry("str", 90), Map.entry("kiw", 70),
                Map.entry("mus", 50)
        );

        double subTotalVeg = 0, subTotalFruit = 0;
        boolean continueShopping = true;

        while (continueShopping) {
            System.out.println("Select category: veggie (v) or fruity (f) : ");
            String category = sc.next().toLowerCase();

            Map<String, Integer> currentMap = category.equals("v") ? vegPrices : fruitPrices;
            double subTotal = category.equals("v") ? subTotalVeg : subTotalFruit;

            boolean yes;
            do {
                System.out.println("Enter item code : ");
                String item = sc.next();

                int price = currentMap.getOrDefault(item, 0);
                if (price > 0) {
                    System.out.println(item + " added to cart. Price: " + price);
                } else {
                    System.out.println("Item not available currently.");
                }

                subTotal += price;

                System.out.println("Continue adding in this category? y/n");
                yes = sc.next().equalsIgnoreCase("y");
            } while (yes);

            if (category.equals("v")) {
                subTotalVeg = subTotal;
                System.out.println("Veggie Total : " + subTotalVeg);
            } else {
                subTotalFruit = subTotal;
                System.out.println("Fruity Total : " + subTotalFruit);
            }

            System.out.println("Do you want to shop in another category? y/n");
            continueShopping = sc.next().equalsIgnoreCase("y");
        }

        double totalPrice = subTotalVeg + subTotalFruit;
        System.out.println("Veggie Total : " + subTotalVeg);
        System.out.println("Fruity Total : " + subTotalFruit);
        System.out.println("Final Total Price : " + totalPrice);

        sc.close();
    }
}
