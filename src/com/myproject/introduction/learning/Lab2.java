package com.myproject.introduction.learning;

import java.util.Scanner;

public class Lab2 {

    static void main() {
//        int num = 100;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        boolean isBtw = num > 100 && num < 999;
        System.out.println("Is Btw : " + isBtw);

        System.out.println("Enter a number: ");
        num = sc.nextInt();

        int into_2 = num << 1;
        System.out.println(num + " * 2 = " + into_2);

        int by_2 = num >> 1;
        num = sc.nextInt();

        System.out.println(num + " / 2 = " + by_2);

//        int a = 10, b = 20, c = 30;
        int a, b, c;
        System.out.println("Enter 3 number: ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        int min = (a < b) ? (a < c ? a : c) : (b < c ? b : c);

        System.out.println("Min of 3  " + min);

        boolean isEven = num % 2 == 0;
        System.out.println(num + " Is Even : " + isEven);

    }
}
