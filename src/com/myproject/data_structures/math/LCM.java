package com.myproject.data_structures.math;

public class LCM {
    public static int findLCM(int a, int b) {
        int lcm = Math.max(a, b);

        while (true) {
            if (lcm % a == 0 && lcm % b == 0) {
                return lcm;
            }
            lcm++;
        }

    }

    static void main() {
        System.out.println(findLCM(12, 18)); // 36
    }
}
