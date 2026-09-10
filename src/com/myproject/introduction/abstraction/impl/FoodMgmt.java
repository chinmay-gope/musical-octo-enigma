package com.myproject.introduction.abstraction.impl;

import com.myproject.introduction.abstraction.FoodOrder;

public class FoodMgmt {

    static void main() {

        FoodOrder foodItem = new PizzaOrder();

        System.out.println("Pizza Bill : " + foodItem.calculateBill());
        System.out.println("Pizza Delivery Charge : " + foodItem.deliveryCharge());

        foodItem = new BurgerOrder();

        System.out.println("Burger Bill : " + foodItem.calculateBill());
        System.out.println("Burger Delivery Charge : " + foodItem.deliveryCharge());

        foodItem = new BiryaniOrder();

        System.out.println("Biryani Bill : " + foodItem.calculateBill());
        System.out.println("Biryani Delivery Charge : " + foodItem.deliveryCharge());

        System.out.println("__________________");
        addToCart(new BiryaniOrder(), 3);

        System.out.println("__________________");
        addToCart(new BurgerOrder(), 2);

        System.out.println("__________________");
        addToCart(new PizzaOrder(), 5);

        System.out.println("__________________");
        addToCart(new PizzaOrder(), -2);
        addToCart(new BurgerOrder(), -2);
        addToCart(new BiryaniOrder(), -2);
    }

    private static void addToCart(FoodOrder order, int qty) {
        String name = order.getClass().getSimpleName().split("Order")[0];

        if (qty <= 0) {
            System.err.println("Enter a valid quantity for " + name);
            return;
        }

        double pricePerItem = order.calculateBill() - order.deliveryCharge();

        double totalBill = pricePerItem * qty + order.deliveryCharge();

//        System.out.println("name = " + name);
        System.out.println("pricePerItem = " + pricePerItem);
        System.out.println("Delivery Charge = " + order.deliveryCharge());
        System.out.println("Total Bill : " + totalBill);

        System.out.println(name + " added to cart! Keep shopping");
    }
}
