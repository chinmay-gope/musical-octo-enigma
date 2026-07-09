package com.myproject.introduction;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerCalculator {

    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Big Number : ");
        var n1 = sc.nextBigInteger();
        System.out.println("Enter a Big Number : ");
        var n2 = sc.nextBigInteger();
        BigInteger num1 = new BigInteger(String.valueOf(n1));
        BigInteger num2 = new BigInteger(String.valueOf(n2));

        print("Addition", add(num1, num2));
        print("Subtraction", subtract(num1, num2));
        print("Multiply", multiply(num1, num2));
        print("Divide", divide(num1, BigInteger.valueOf(500)));
        print("Divide", divide(num1, BigInteger.valueOf(0)));
        print("Divide", divide(num1, num2));
        print("Modulo", mod(num1, num2));
        print("Power n1(2)", pow(num1, 2));
        print("Power n1(3)", pow(num1, 3));
    }

    BigInteger add(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    BigInteger subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    BigInteger multiply(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    BigInteger divide(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            System.out.println("Division by zero is not allowed.");
            return BigInteger.ZERO;
        }
        return a.divide(b);
    }

    BigInteger mod(BigInteger a, BigInteger b) {
        return a.mod(b);
    }

    BigInteger pow(BigInteger base, int exponent) {
        return base.pow(exponent);
    }

    void print(String operation, BigInteger result) {
        System.out.printf("%-15s : %s%n", operation, result);
    }
}