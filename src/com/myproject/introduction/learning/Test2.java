package com.myproject.introduction.learning;

public class Test2 {

    static {
        System.out.println("static-block");
    }

    {
        System.out.println("instance-block-1");
    }

    {
        System.out.println("instance-block-2");
    }

    Test2() {
        System.out.println(this);
//        System.out.println(this.display());
        System.out.println("constructor-called");
    }

    @Override
    public String toString() {
        return "Hello World";
    }

    void display() {
        System.out.println("display");
    }

    void main() {
        Test2 t1 = new Test2();
        Test2 t2 = new Test2();

        t1.display();
        t2.display();
    }
}
