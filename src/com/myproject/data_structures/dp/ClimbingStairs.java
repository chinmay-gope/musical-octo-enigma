package com.myproject.data_structures.dp;

public class ClimbingStairs {
    static void main() {

        System.out.println("climbStairs(5) = " + climbStairs(5));
        System.out.println("climbStairs(10) = " + climbStairs(10));

        System.out.println();

        System.out.println("climbStairsTab(10) = " + climbStairsTab(10));
        System.out.println("climbStairsTab(45) = " + climbStairsTab(45)); // 1836311903
    }

    private static int climbStairsTab(int n) {
        if (n == 1 || n == 2) return n;
/*      int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
 */
        int prev2 = 1; // n-2
        int prev1 = 2; // n-1

        int res = prev1;

        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
            res = prev1 + prev2;
            prev2 = prev1;
            prev1 = res;
        }

        return res;
//        return dp[n];
    }

    static int climbStairs(int n) {
        return climbStairs(n, new int[n + 1]);
    }

    private static int climbStairs(int n, int[] dp) {
        if (n == 1 || n == 2) return n;
        if (dp[n] != 0) return dp[n];

        return dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
    }

}
