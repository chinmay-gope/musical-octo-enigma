package com.myproject.introduction.accessmodfr;

public class Product {

    private static int nextProductId = 100;

    private final int productId;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {

        this.productId = ++nextProductId;
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

    public int getProductId() {
        return productId;
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

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
