package com.myproject.streams;

public class Parent {
    Parent(int a) {
        System.out.println("Parent Constructor with a = " + a);
    }

    Parent() {
        this(10);
        System.out.println("Parent Constructor");
    }

    static void main() {
        Parent p = new Parent(20);
        Parent p1 = new Parent();
    }
}
