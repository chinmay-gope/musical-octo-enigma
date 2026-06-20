package com.myproject.data_structures.math;

public class GCD {

    //   O(min(a, b))
    int gcd(int a, int b) {
        int gcd = 1;
        for (int i = 1; i < Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    //   O(log(min(a, b)))
    int gcd(int a, int b, boolean optimizedTime) {
        if (!optimizedTime) return gcd(a, b);

        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0) return b;
        return a;
    }

    int gcdRecursive(int a, int b) {
        if (b == 0) return a;
        return gcdRecursive(b, a % b);
    }

    int lcm(int a, int b) {
        return (a * b) / gcdRecursive(a, b);
    }

    void main() {
        IO.println(gcd(20, 28, false));
        IO.println(gcd(50, 75, true));

        IO.println(gcdRecursive(5345, 25));
        IO.println(gcdRecursive(340, 75));

        IO.println("__lcm__");
        IO.println(lcm(5, 10));
        IO.println(lcm(15, 20));

    }
}
