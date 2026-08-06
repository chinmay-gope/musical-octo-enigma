package com.myproject.introduction.learning;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Practice {
    static Map<Integer, Long> memo = new HashMap<>();
    static Map<Integer, BigInteger> bigMemo = new HashMap<>();

    static long factorial(int n) {
        if (n == 0) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        long result = n * factorial(n - 1);
        memo.put(n, result);
        return result;
    }

    static BigInteger bigFactorial(int n) {
        if (n == 0) return BigInteger.ONE;

        if (bigMemo.containsKey(n)) return bigMemo.get(n);

//        result =  n * bigFactorial(n- 1)
        BigInteger result = BigInteger.valueOf(n).multiply(bigFactorial(n - 1));

        bigMemo.put(n, result);
        System.out.println(n + "! = " + bigMemo.get(n));

        return result;
    }


    static void main() {
        IO.println(factorial(9));
        IO.println("Factorial : " + bigFactorial(9));
        IO.println("Factorial : " + bigFactorial(2));
        IO.println("Factorial : " + bigFactorial(4));
        IO.println("Factorial : " + bigFactorial(7));
        IO.println("Factorial : " + bigFactorial(12));
        System.out.println("--------------------------");
        for (Integer key : bigMemo.keySet()) {
            IO.println(key + "! : " + bigMemo.get(key));
        }
    }
}
