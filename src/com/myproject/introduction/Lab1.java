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

    }

    int square(int a) {
        return a * a;
    }
}
