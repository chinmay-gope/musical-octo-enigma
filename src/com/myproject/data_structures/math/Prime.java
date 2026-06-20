package com.myproject.data_structures.math;

import java.util.Arrays;

public class Prime {

    void isPrime(int n) {
//        i <= sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                IO.println("Not prime");
                return;
            }
        }
        IO.println("Prime");
    }

    int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }

    //    Time Complexity: O(n log log n)
    int countPrimes(int n, boolean optimizedTime) {
        if (n <= 2) return 0;
        if (!optimizedTime) return countPrimes(n);

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
             /*
               j = i^2 Because all smaller multiples (2i, 3i, ..., (i-1)i)
               have already been marked by smaller primes.
              */
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }

    void main() {
        isPrime(10);
        isPrime(97);

        IO.println("__countPrimes__");
        IO.println(countPrimes(100));
        IO.println(countPrimes(50, false));

        IO.println(countPrimes(590, true)); //107
        IO.println(countPrimes(670, true)); //121
    }
}
