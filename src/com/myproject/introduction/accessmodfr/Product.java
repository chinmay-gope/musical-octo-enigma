package com.myproject.introduction.accessmodfr;

public class Product {

    private int productId;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addStock(int stockQty) {
        if (stockQty > 0) {
            this.quantity += stockQty;
        } else {
            System.err.println("Cannot add Negative qty.");
        }
    }

    public void removeStock(int stockQty) {
        if (stockQty > 0 && stockQty <= this.quantity) {
            this.quantity -= stockQty;
        } else {
            System.err.println("Cannot exceed the available qty available in the inventory.");
        }
    }

    // Getters Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
