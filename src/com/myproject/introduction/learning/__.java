package com.myproject.introduction.learning;

public class __ {
    __() {
        System.out.println("\nThis is a '__' constructor");
    }

    int _a;
    int $b;

    static {
        System.out.println("\nCollege name with one '_' is accepting as className.");
        System.out.println("But cannot execute the code..");
    }

    {
        System.out.println("\nWhere as '__' is fine with file_name and execution.");
        System.out.println("Also combination of _$ is accepted.");
    }

    static void main() {
        System.out.println("\nmain method started");
        __ __ = new __(); //Using '_' as a reference is not allowed

        System.out.println("\nCAN assign '_' as a Object Reference");
        __._a = 10;
        __.$b = 20;

        System.out.println("But CANNOT access class level variables like: '_._a' its not allowing");

        System.out.println("\u001B[96mHello\u001B[0m World");

    }
}
