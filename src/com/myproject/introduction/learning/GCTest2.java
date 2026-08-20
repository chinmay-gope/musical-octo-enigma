package com.myproject.introduction.learning;

public class GCTest2 {
    static void main() {
        GCTest2 obj1 = new GCTest2();
        GCTest2 obj2 = new GCTest2();
        GCTest2 obj3 = new GCTest2();

        obj2 = obj1;
        obj2 = obj3;
        obj3 = null;

        System.out.println("obj1 = " + obj1);
        System.out.println("obj2 = " + obj2);
        System.out.println("obj3 = " + obj3);

        System.gc();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("this = " + this);
    }
}
