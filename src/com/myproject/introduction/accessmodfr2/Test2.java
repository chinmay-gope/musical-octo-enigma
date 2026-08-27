package com.myproject.introduction.accessmodfr2;

import com.myproject.introduction.accessmodfr.Customer;

public class Test2 {
    static void main() {
        Customer customer = new Customer();

        customer.setEmail("test");
        customer.setName("");

        customer.setEmail("test@email.com");
        System.out.println(customer.getEmail());

        customer.setName("Test");
        System.out.println(customer.getName());

        customer.setPhoneNumber("432");
        System.out.println(customer.getPhoneNumber());

        customer.setPhoneNumber("4324324321");
        System.out.println(customer.getPhoneNumber());
    }
}
