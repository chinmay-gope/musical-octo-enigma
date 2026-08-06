package com.myproject.introduction.learning;

class A {
    B b;

    @Override
    protected void finalize() {
        System.out.println("finalize called A");
        //  System.out.println(objCount++ + " from A");
    }
}

class B {
    A a;

    @Override
    protected void finalize() {
        System.out.println("finalize called B");
        //  System.out.println(objCount++ + " from B");
    }
}

public class Island {

    void main() {
        A a1 = new A();
        B b1 = new B();

        a1.b = b1;
        b1.a = a1;

        a1 = null;
        //  Thread.sleep(1000);
        b1 = null;

        System.gc();
    }

//    @Override
//    protected void finalize() {
//        System.out.println("finalize called");
//       // System.out.println(objCount++ + " from main");
//    }
}
