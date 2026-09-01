package com.myproject.introduction.accessmodfr;

import java.util.Arrays;

public class Cart {

    private final Product[] cartItems;
    private int count = 0;

    public Cart(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Cart size cannot be negative");
        }

        this.cartItems = new Product[size];
    }

    public void addItem(Product product) {

        if (product == null) {
            System.err.println("Invalid item. Cannot add.");
            return;
        }

        if (count >= cartItems.length) {
            System.err.println("Cart is full. Cannot add more items.");
            return;
        }

        cartItems[count] = product;
        count++;
    }

    public void removeItem(int index) {

        if (index < 0 || index >= count) {
            System.err.println("Invalid index: " + index);
            return;
        }

        // Shift elements to the left
        for (int i = index; i < count - 1; i++) {
            cartItems[i] = cartItems[i + 1];
        }

        // Remove duplicate last reference
        cartItems[count - 1] = null;

        count--;
    }

    // Remove item by name
    public void removeItem(int productId, boolean byProductId) {

        for (int i = 0; i < count; i++) {

            if (cartItems[i].getProductId() == productId) {
                removeItem(i);
                return;
            }
        }

        System.err.println("Product not found: " + productId);
    }

    public double getTotalAmount() {

        double total = 0;

        for (int i = 0; i < count; i++) {
            total += cartItems[i].getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Cart{" + "cartItems=" + Arrays.toString(cartItems) +
                ", totalAmount=" + getTotalAmount() +
                ", count=" + count + '}';
    }
}
