package com.myproject.introduction;

public class Employee {
    static Employee emp = new Employee();

    //     static -> instance (done)
//     static -> static   (done)
//     instance -> static (done)
//     instance -> instance (done)
    static void main() {
        System.out.println("Started");
        emp.method1();
        System.out.println("Ended");
    }

    void method1() {
        method2();
        method1(2);
        System.out.println("method1");
    }

    void method1(int k) {
        System.out.println("method1 K:" + k);
    }

    static void method2(int k) {
        System.out.println("method1 K:" + k);
    }

    static void method2() {
        emp.method3();
        method4();
        method2(5);
        System.out.println("method2");
    }

    void method3() {
        method5();
        System.out.println("method3");
    }

    static void method4() {
        System.out.println("method4");
    }

    void method5() {
        System.out.println("method5");
    }

}
