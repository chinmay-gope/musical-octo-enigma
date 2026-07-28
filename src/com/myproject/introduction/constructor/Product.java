package com.myproject.introduction.constructor;

public class Product {
    String prodID, name, brand;
    int warrantyInYrs;
    double price;

    // Parameterized constructor
    public Product(String prodID, String name, String brand, double price, int warrantyInYrs) {
        this.prodID = prodID;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.warrantyInYrs = warrantyInYrs;
    }

    // Copy constructor
    public Product(Product other, String newProdID) {
        this.prodID = newProdID; // only prodID is changed
        this.name = other.name;
        this.brand = other.brand;
        this.price = other.price;
        this.warrantyInYrs = other.warrantyInYrs;
    }

    // Display method
    public void display() {
        System.out.printf(
                "Product ID: %s\n" +
                        "Product Name: %s\n" +
                        "Product Brand: %s\n" +
                        "Price: %.2f\n" +
                        "Warranty: %d (in Yrs) \n" +
                        "______________________________________\n",
                prodID, name, brand, price, warrantyInYrs
        );
    }

    static void main() {
        Product original = new Product("P1001", "Smartphone", "TechBrand", 29999.99, 1);

        // Copy product with new prodID
        Product copy = new Product(original, "P2001");

        // Display both records
        System.out.println("Original Product Record:");
        original.display();

        System.out.println("Copied Product Record:");
        copy.display();
    }
}
