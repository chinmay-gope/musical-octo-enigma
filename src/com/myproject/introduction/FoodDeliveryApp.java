package com.myproject.introduction;

import java.util.Scanner;

public class FoodDeliveryApp {
    static void main() {
        System.out.println("Welcome to Food Delivery App");
        Scanner sc = new Scanner(System.in);

        double subTotalVeg = 0, subTotalNonVeg = 0, subTotalBeverages = 0;
        boolean continueShopping = true;

        while (continueShopping) {
            System.out.println("Select category: veg (v), non-veg (n), beverages (b): ");
            String category = sc.next().toLowerCase();

            switch (category) {
                case "v" -> {
                    boolean yes;
                    do {
                        System.out.println("Enter veg items (pnb - Paneer Biryani, vbg - Veg Burger, vpz - Veg Pizza): ");
                        String item = sc.next();

                        double vegTotal = switch (item) {
                            case "pnb" -> {
                                System.out.println("Paneer Biryani added to cart. Price: 200");
                                yield 200;
                            }
                            case "vbg" -> {
                                System.out.println("Veg Burger added to cart. Price: 120");
                                yield 120;
                            }
                            case "vpz" -> {
                                System.out.println("Veg Pizza added to cart. Price: 250");
                                yield 250;
                            }
                            default -> {
                                System.out.println("Veg item not available currently.");
                                yield 0;
                            }
                        };

                        subTotalVeg += vegTotal;

                        System.out.println("Continue adding veg items? y/n");
                        yes = sc.next().equalsIgnoreCase("y");
                    } while (yes);

                    System.out.println("Veg Total : " + subTotalVeg);
                }

                case "n" -> {
                    boolean yes;
                    do {
                        System.out.println("Enter non-veg items (cbn - Chicken Biryani, cbg - Chicken Burger, cpz - Chicken Pizza): ");
                        String item = sc.next();

                        double nonVegTotal = switch (item) {
                            case "cbn" -> {
                                System.out.println("Chicken Biryani added to cart. Price: 300");
                                yield 300;
                            }
                            case "cbg" -> {
                                System.out.println("Chicken Burger added to cart. Price: 180");
                                yield 180;
                            }
                            case "cpz" -> {
                                System.out.println("Chicken Pizza added to cart. Price: 350");
                                yield 350;
                            }
                            default -> {
                                System.out.println("Non-veg item not available currently.");
                                yield 0;
                            }
                        };

                        subTotalNonVeg += nonVegTotal;

                        System.out.println("Continue adding non-veg items? y/n");
                        yes = sc.next().equalsIgnoreCase("y");
                    } while (yes);

                    System.out.println("Non-Veg Total : " + subTotalNonVeg);
                }

                case "b" -> {
                    boolean yes;
                    do {
                        System.out.println("Enter beverage items (tea - Tea, cof - Coffee, jus - Juice): ");
                        String item = sc.next();

                        double bevTotal = switch (item) {
                            case "tea" -> {
                                System.out.println("Tea added to cart. Price: 20");
                                yield 20;
                            }
                            case "cof" -> {
                                System.out.println("Coffee added to cart. Price: 50");
                                yield 50;
                            }
                            case "jus" -> {
                                System.out.println("Juice added to cart. Price: 80");
                                yield 80;
                            }
                            default -> {
                                System.out.println("Beverage not available currently.");
                                yield 0;
                            }
                        };

                        subTotalBeverages += bevTotal;

                        System.out.println("Continue adding beverages? y/n");
                        yes = sc.next().equalsIgnoreCase("y");
                    } while (yes);

                    System.out.println("Beverages Total : " + subTotalBeverages);
                }

                default -> System.out.println("Invalid category choice.");
            }

            System.out.println("Do you want to shop in another category? y/n");
            continueShopping = sc.next().equalsIgnoreCase("y");
        }

        double totalPrice = subTotalVeg + subTotalNonVeg + subTotalBeverages;

        System.out.println("Veggie Total : " + subTotalVeg);
        System.out.println("Non-Veg Total : " + subTotalNonVeg);
        System.out.println("Beverages Total : " + subTotalBeverages);
        System.out.println("__________________________");
        System.out.println("Final Total Price : " + totalPrice);

        sc.close();
    }
}
