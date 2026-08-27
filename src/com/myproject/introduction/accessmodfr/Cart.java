package com.myproject.introduction.accessmodfr;

import java.util.Arrays;

public class Cart {

    private final String[] cartItems;
    //    private double totalAmount;
    private int count = 0;

    public Cart(int size) {
        this.cartItems = new String[size];
    }

    public void addItem(String item) {
        if (count < cartItems.length) {
            cartItems[count++] = item.toUpperCase();
//            count++;
        } else {
            System.err.println("Cart is full. Cannot add more items.");
        }
    }

    public void removeItem(int productId) {
        for (int i = 0; i < cartItems.length; i++) {
            if (productId == i) {
                cartItems[i] = null;
                count--;
            }
        }
    }

    public void removeItem(String productName) {
        for (int i = 0; i < cartItems.length; i++) {
            if (productName.equalsIgnoreCase(cartItems[i])) {
                cartItems[i] = null;
            }
        }
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (String cartItem : cartItems) {
            if (cartItem != null) {
                totalAmount = totalAmount + 10;
            }
        }
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Cart{" + "cartItems=" + Arrays.toString(cartItems) + ", totalAmount=" + getTotalAmount() + ", count=" + count + '}';
    }
}
