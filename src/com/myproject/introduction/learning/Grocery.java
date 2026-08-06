package com.myproject.introduction.learning;

import java.util.Scanner;

public class Grocery {
    static void main() {
        System.out.println("Welcome to Grocery store");
        Scanner sc = new Scanner(System.in);

        double subTotalVeg = 0, subTotalFruit = 0;
        boolean continueShopping = true;

        while (continueShopping) {
            System.out.println("Select category: veggie (v) or fruity (f) : ");
            String category = sc.next().toLowerCase();

            switch (category) {
                case "v" -> {
                    boolean yes;
                    do {
                        System.out.println("Enter veg items : ");
                        String item = sc.next();

                        double vegTotal = switch (item) {
                            case "tmt" -> {
                                System.out.println("Tomato added to cart.");
                                yield 20;
                            }
                            case "ptt" -> {
                                System.out.println("Potato added to cart.");
                                yield 10;
                            }
                            case "bjl" -> {
                                System.out.println("Brinjal added to cart.");
                                yield 10;
                            }
                            case "oni" -> {
                                System.out.println("Onion added to cart.");
                                yield 15;
                            }
                            case "car" -> {
                                System.out.println("Carrot added to cart.");
                                yield 25;
                            }
                            case "cab" -> {
                                System.out.println("Cabbage added to cart.");
                                yield 30;
                            }
                            case "cap" -> {
                                System.out.println("Capsicum added to cart.");
                                yield 40;
                            }
                            case "cuc" -> {
                                System.out.println("Cucumber added to cart.");
                                yield 20;
                            }
                            case "pea" -> {
                                System.out.println("Green peas added to cart.");
                                yield 50;
                            }
                            case "cor" -> {
                                System.out.println("Corn added to cart.");
                                yield 35;
                            }
                            case "spi" -> {
                                System.out.println("Spinach added to cart.");
                                yield 20;
                            }
                            case "cau" -> {
                                System.out.println("Cauliflower added to cart.");
                                yield 45;
                            }
                            case "bea" -> {
                                System.out.println("Beans added to cart.");
                                yield 30;
                            }
                            default -> {
                                System.out.println("Veggie not available currently.");
                                yield 0;
                            }
                        };

                        subTotalVeg += vegTotal;

                        System.out.println("Continue adding veggies? y/n");
                        yes = sc.next().equalsIgnoreCase("y");
                    } while (yes);

                    System.out.println("Veggie Total : " + subTotalVeg);
                }

                case "f" -> {
                    boolean yes;
                    do {
                        System.out.println("Enter fruity items : ");
                        String item = sc.next();

                        double fruitTotal = switch (item) {
                            case "mng" -> {
                                System.out.println("Mango added to cart.");
                                yield 50;
                            }
                            case "app" -> {
                                System.out.println("Apple added to cart.");
                                yield 30;
                            }
                            case "grp" -> {
                                System.out.println("Grapes added to cart.");
                                yield 40;
                            }
                            case "ban" -> {
                                System.out.println("Banana added to cart.");
                                yield 20;
                            }
                            case "org" -> {
                                System.out.println("Orange added to cart.");
                                yield 35;
                            }
                            case "wat" -> {
                                System.out.println("Watermelon added to cart.");
                                yield 60;
                            }
                            case "pap" -> {
                                System.out.println("Papaya added to cart.");
                                yield 45;
                            }
                            case "pna" -> {
                                System.out.println("Pineapple added to cart.");
                                yield 55;
                            }
                            case "guv" -> {
                                System.out.println("Guava added to cart.");
                                yield 30;
                            }
                            case "pom" -> {
                                System.out.println("Pomegranate added to cart.");
                                yield 80;
                            }
                            case "str" -> {
                                System.out.println("Strawberry added to cart.");
                                yield 90;
                            }
                            case "kiw" -> {
                                System.out.println("Kiwi added to cart.");
                                yield 70;
                            }
                            case "mus" -> {
                                System.out.println("Muskmelon added to cart.");
                                yield 50;
                            }
                            default -> {
                                System.out.println("Fruit not available currently.");
                                yield 0;
                            }
                        };

                        subTotalFruit += fruitTotal;

                        System.out.println("Continue adding fruits? y/n");
                        yes = sc.next().equalsIgnoreCase("y");
                    } while (yes);

                    System.out.println("Fruity Total : " + subTotalFruit);
                }

                default -> System.out.println("Invalid category choice.");
            }

            //  query to switch category
            System.out.println("Do you want to shop in another category? y/n");
            continueShopping = sc.next().equalsIgnoreCase("y");
        }

        double totalPrice = subTotalVeg + subTotalFruit;

        System.out.println("Veggie Total : " + subTotalVeg);
        System.out.println("Fruity Total : " + subTotalFruit);
        System.out.println("__________________________");
        System.out.println("Final Total Price : " + totalPrice);
        sc.close();
    }
}
