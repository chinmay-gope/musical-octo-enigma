package com.myproject.data_structures.math;

public class Armstrong {

    boolean isArmstrong(int n) {
        int original = n;

        int sum = 0;
        int digitCount = String.valueOf(n).length();
//        int digitCount = (int) Math.log10(n) + 1;

        while (n != 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, digitCount);
            n = n / 10;
        }
        return sum == original;
    }

    void main() {
        IO.println("__isArmstrong__");
        IO.println(isArmstrong(153));
        IO.println(isArmstrong(371));
        IO.println(isArmstrong(9474));
    }
}
