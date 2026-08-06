package com.myproject.introduction.learning;

import java.util.Scanner;

public class MyBoolean {
    static void main() {
        Scanner sc = new Scanner(System.in);
        MyBoolean obj = new MyBoolean();

        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("isEven: " + obj.isEven(n));
        System.out.println("isOdd: " + obj.isOdd(n));
        System.out.println("isPrime: " + obj.isPrime(n));
        System.out.println("isPositive: " + obj.isPositive(n));
        System.out.println("isNegative: " + obj.isNegative(n));

        System.out.print("Enter a Year: ");
        int year = sc.nextInt();
        System.out.println("isLeapYear: " + obj.isLeapYear(year));

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.println("isAdult: " + obj.isAdult(age));
        System.out.println("isEligibleToVote: " + obj.isEligibleToVote(age));

        System.out.print("Enter score: ");
        int score = sc.nextInt();
        System.out.println("hasPassed: " + obj.hasPassed(score));
        sc.nextLine(); // consume newline

        System.out.print("Enter a Palindrome: ");
        String palindrome = sc.nextLine();
        System.out.println("isPalindrome: " + obj.isPalindrome(palindrome));
    }

    boolean isEven(int n) {
        return n % 2 == 0;
    }

    boolean isOdd(int n) {
        return n % 2 != 0;
    }

    boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    boolean isPositive(int n) {
        return n > 0;
    }

    boolean isNegative(int n) {
        return n < 0;
    }

    boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    boolean isAdult(int age) {
        return age >= 18;
    }

    boolean isEligibleToVote(int age) {
        return isAdult(age);
    }

    boolean hasPassed(int score) {
        return score >= 75;
    }

    boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
