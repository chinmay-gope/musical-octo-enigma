package com.myproject.introduction;

import java.util.Scanner;

public class Lab1 {
    static void main() {
        Lab1 lab1 = new Lab1();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int n1 = lab1.square(n);
        System.out.println("Square is " + n1);

        System.out.println(lab1.meth());
        System.out.println(lab1.meth2());
        System.out.println(lab1.meth3());
        System.out.println(lab1.meth4());
        System.out.println(lab1.meth5());
        System.out.println(lab1.meth6().length());
        System.out.println(lab1.meth7().length());
        System.out.println(lab1.meth8().length());
    }

    int meth() {
        return 'A';
    }

    char meth2() {
        return 100;
    }

    boolean meth3() {
        return 130 == Integer.valueOf(130);
    }

    char meth4() {
        return 10 + 'B';
    }

    double meth5() {
        return 5.0 / 0;
    }

    String meth6() {
        return Integer.toString(00);
    }

    String meth7() {
        return Integer.toString(002);
    }
    String meth8() {
        return Integer.toString(0023);
    }

    int square(int a) {
        return a * a;
    }
}
