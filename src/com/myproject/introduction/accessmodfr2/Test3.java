package com.myproject.introduction.accessmodfr2;

import com.myproject.introduction.accessmodfr.Cart;
import com.myproject.introduction.accessmodfr.Product;

public class Test3 {
    static void main() {
        Cart cart = new Cart(5);

        cart.addItem("apple");
        cart.addItem("mango");
        cart.addItem("guava");
        System.out.println(cart);
//        System.out.println("cart = " + Arrays.toString(cart.getCartItems()));

        cart.addItem("black-berry");
        System.out.println(cart);

        cart.removeItem(2);
        System.out.println(cart);

        cart.removeItem("mango");
        System.out.println(cart);

//        testProduct();
    }

    static void testProduct() {
        Product p = new Product(101, "Laptop", 300000, 3);

        p.addStock(1);
        System.out.println("qty = " + p.getQuantity());

        p.addStock(-2);
        System.out.println("qty = " + p.getQuantity());

        p.removeStock(5);
        System.out.println("qty = " + p.getQuantity());

        p.removeStock(2);
        System.out.println("qty = " + p.getQuantity());
    }
}
