package com.myproject.introduction.learning;

public class DisariumNumber {

    static void isDisariumNumber(int n) {

        int temp = n;
        int sum = 0;
        int len = Integer.toString(n).length();

        while (n > 0) {
            double r = n % 10; //  5 3 1
            n = n / 10; // 13 1
            sum += (int) Math.pow(r, len);
            len--;
        }

        if (sum == temp) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // 1^1 + 3^2+ 5^3
    static void main() {
        isDisariumNumber(135);
        isDisariumNumber(89);
        isDisariumNumber(175);
        isDisariumNumber(81); // F
    }
}
