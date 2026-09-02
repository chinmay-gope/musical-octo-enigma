package com.myproject.introduction.learning;

public class MyIOFunction implements IOFunction {

    static void main() {
        MyIOFunction fn = new MyIOFunction();

        fn.run();
        fn.f1();
        IOFunction.f2();
        System.out.println(fn);

        System.out.println("__________");
        IOFunction.main();
    }

    @Override
    public void run() {
        System.out.println("MyIOFunction.run");
    }

    @Override
    public void f1() {
        IOFunction.super.f1();
    }
}
