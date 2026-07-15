package com.myproject.introduction.constructor;

public class Product {
    String name;
    double price;

    Product() {
    }

    static  class Laptop extends Product {
        Laptop() {
        }

        int id;
        String brand;

        static void main() {
            Laptop l1 = new Laptop();
            l1.id = 1;
            l1.brand = "Laptop";

            System.out.println(l1.id + " " + l1.brand);
        }
    }

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void show() {
        System.out.println("name: " + name);
        System.out.println("price: " + price);
    }

    static void main() {
        Product p1 = new Product("P1", 50);
        Product p2 = new Product("P2", 50);
        Laptop l1 = new Laptop();

        p1.show();
        p2.show();
        l1.show();
    }
}
