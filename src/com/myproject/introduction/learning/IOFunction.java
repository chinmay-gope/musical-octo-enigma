package com.myproject.introduction.learning;

@FunctionalInterface
public interface IOFunction extends Runnable {
    static void f2() {
        System.out.println("IOFunction.f2 called");
    }

    static void main() {
        System.out.println("Hello from Interface");
        System.out.println("IOFunction.main");

        f2();

        IOFunction f = () -> {
            System.out.println("Hello from Lambda");
        };

        System.out.println(f);
        f.run();
    }

    void run();

    String toString();

    boolean equals(Object obj);

    int hashCode();

/*  cus it's not public and instance method.
    It qualifies as another abstract method

  An Interface implicitly declares abstract methods for all "public methods" in the Object class
    */
//    Object clone() throws CloneNotSupportedException;

    default void f1() {
        System.out.println("IOFunction.f1 called");
    }
}
