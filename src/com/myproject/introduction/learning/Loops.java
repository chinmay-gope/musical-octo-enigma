package com.myproject.introduction.learning;

import java.util.Scanner;

public class Loops {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a isHappyNumber: ");
        int n = sc.nextInt();
        boolean isHappy = isHappy(n);

        if (isHappy) {
            System.out.println("The number is happy");
        } else {
            System.out.println("The number is not happy");
        }


        System.out.print("Enter a isNeonNumber: ");
        n = sc.nextInt();
        System.out.println(isNeonNumber(n));
        System.out.println(isNeonNumber(19));

        System.out.print("Enter a Decimal Number: ");
        n = sc.nextInt();
        String bin = decimalToBinary(n);
        System.out.println("Binary of " + n + " is : " + bin);

        System.out.print("Enter a Binary Number: ");
        n = sc.nextInt();

        System.out.println("Decimal2 of " + n + " is : " + binaryToDecimal(String.valueOf(n)));

        System.out.println("Enter a number (n th odd number)");
        int k = findNthOddNumber(n);

        System.out.println(k);

        System.out.println("Enter a number (odd number in range)");
        n = sc.nextInt();

        findOddNumbersInRange(n);

        System.out.println("Enter a number : ");
        n = sc.nextInt();
        System.out.println("Enter Nth value : ");
        k = sc.nextInt();

        findNthFactorOfANumber(n, k);

        printEven(70);

        System.out.print("Enter a number: ");
        n = sc.nextInt();

        swapFirstLastDigit(n);
        swapFirstLastDigitArithmetic(n);
    }

    public static void swapFirstLastDigit(int num) {
        String str = Integer.toString(num);
        int n = str.length();

        if (n == 1) {
            System.out.println("Output: " + num);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sb.append(str.charAt(n - 1));
            } else if (i == n - 1) {
                sb.append(str.charAt(0));
            } else {
                sb.append(str.charAt(i));
            }
        }

        System.out.println("Output: " + sb);
    }

    public static void swapFirstLastDigitArithmetic(int num) {
        if (num < 10) {
            System.out.println("Output: " + num);
            return;
        }

        int temp = num;
        int digits = 0;

        while (temp > 0) {
            temp /= 10;
            digits++;
        }

        int firstDigit = num;
        while (firstDigit >= 10) {
            firstDigit /= 10;
        }

        int lastDigit = num % 10;

        // Remove first digit contribution
        int middlePart = num % (int) Math.pow(10, digits - 1);
        middlePart /= 10; // strip last digit

        int firstLastSwapped = lastDigit * (int) Math.pow(10, digits - 1)
                + middlePart * 10
                + firstDigit;

        System.out.println("firstLastSwapped: " + firstLastSwapped);
    }


    public static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static boolean isHappy(int num) {
        int slow = num;
        int fast = num;

        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static boolean isNeonNumber(int num) {
        int sq = num * num;
        int sum = 0;

        while (sq > 0) {
            sum += sq % 10;
            sq /= 10;
        }

        return sum == num;
    }

    public static String decimalToBinary(int num) {
        StringBuilder binary = new StringBuilder();

        while (num > 0) {

            int r = num % 2;
            num = num / 2;
            binary.insert(0, r);
        }

        return binary.toString();
    }

/*    public static int binaryToDecimal2(int num) {
        int decimal = 0;
        int base = 1; // 2^0

        while (num > 0) {
            int digit = num % 10;
            num = num / 10;

            decimal += digit * base;
            base = base * 2;
        }

        return decimal;
    }*/

    public static int binaryToDecimal(String num) {
        int strLen = num.length(), sum = 0;

        for (int i = 0; i < strLen; i++) {

            if (num.charAt(i) != '0' && num.charAt(i) != '1') {
                System.out.println(num + " is a Invalid binary format");
                return -1;
            }

            if (num.charAt(i) == '1') {
                sum = (int) (sum + Math.pow(2, strLen - i - 1));
            }
        }

        return sum;
    }


    public static void findNthFactorOfANumber(int number, int nth) {
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


    public static void findOddNumbersInRange(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static int findNthOddNumber(int n) {
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
