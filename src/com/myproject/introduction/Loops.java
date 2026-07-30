package com.myproject.introduction;

import java.util.Scanner;

public class Loops {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number (n th odd number)");
        int n = sc.nextInt();
        int k = findNthOddNumber(n);

        System.out.println(k);

        System.out.println("Enter a number (odd number in range)");
        n = sc.nextInt();

        findOddNumbersInRange(n);

        System.out.println("Enter a number : ");
        n = sc.nextInt();
        System.out.println("Enter Nth value : ");
        int nth = sc.nextInt();

        findNthFactorOfANumber(n, nth);

        printEven(70);
        sc.close();
    }

    private static void findNthFactorOfANumber(int number, int nth) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
                if (count == nth) {
                    System.out.println("The " + nth + "th factor of " + number + " is: " + i);
                    return;
                }
            }
        }

        System.out.println(number + " has fewer than " + nth + " factors.");
    }


    static void printEven(int n) {
        if (n == 0) return;

        if (n % 2 == 0) {
            System.out.print(n + " ");
        }

        printEven(n - 1);
    }


    private static void findOddNumbersInRange(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static int findNthOddNumber(int n) {
        int count = 0;
        for (int i = 1; i < 2 * n; i++) {
            if (i % 2 == 1) {
                count++;
            }

            if (count == n) {
                return i;
            }
        }
        return 0;
    }
}
