package com.myproject.introduction.learning;

import java.util.Scanner;

public class lab5 {
    static void main() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        boolean status = isStrong(n);

        System.out.println("Given number is Strong : " + status);
        System.out.println("Given number is Palindrome : " + isPalindrome(n));
    }

    private static boolean isPalindrome(int n) {
        int rev = 0;
        int temp = n;

        while (n > 0) {
            int rem = n % 10; // last  digit
            rev = rev * 10 + rem;
            n = n / 10;
        }

        return rev == temp;
    }

    private static boolean isStrong(int n) {
        int sum = 0, temp = n;

        while (n > 0) {
            int rem = n % 10; //get last digit
            sum = sum + factorial(rem);
            n = n / 10;
        }

        return sum == temp;
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }


}
