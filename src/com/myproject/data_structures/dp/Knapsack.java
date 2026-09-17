package com.myproject.data_structures.dp;

import java.util.Arrays;

public class Knapsack {

    static void main() {
        int[][] items = {{60, 10}, {100, 20}, {120, 30}, {80, 40}, {150, 15}}; // {value, weight}
        int K = 60;

        System.out.println(fractionalKnapsack(items, K));

        items = new int[][]{{20, 2}, {30, 3}, {50, 4}, {60, 5}, {100, 9}};// {value, weight}
        K = 10;

        System.out.println("knapsack01_Recursion = " + knapsack01_Rec(items, K));
        System.out.println("knapsack01_MemoizationDP = " + knapsack01_MemoDP(items, K));
        System.out.println("knapsack01_TabulationDP = " + knapsack01_TabDP(items, K));
    }

    static int knapsack01_Rec(int[][] items, int W) {
        return knapsack01(items, W, items.length);
    }

    static int knapsack01_MemoDP(int[][] items, int W) {
        int[][] memo = new int[items.length + 1][W + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return knapsack01(items, W, items.length, memo);
    }

    static int knapsack01_TabDP(int[][] items, int W) {
        int N = items.length;
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                int val = items[i - 1][0];
                int wt = items[i - 1][1];

                if (wt <= j) {
                    dp[i][j] = Math.max(val + dp[i - 1][j - wt], dp[i - 1][j]); // max(inc, exc)
                } else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[N][W];
    }

    // Memoization helper
    private static int knapsack01(int[][] items, int W, int N, int[][] dp) {
        if (N == 0 || W == 0) return 0;
        if (dp[N][W] != -1) return dp[N][W]; // already calc value in [N,W].

        int val = items[N - 1][0];
        int wt = items[N - 1][1];
        if (wt <= W) {
            int include = val + knapsack01(items, W - wt, N - 1, dp);
            int exclude = knapsack01(items, W, N - 1, dp);
            return dp[N][W] = Math.max(exclude, include);
        } else return dp[N][W] = knapsack01(items, W, N - 1, dp);
    }

    // Recursion helper
    private static int knapsack01(int[][] items, int W, int N) {
        if (N == 0 || W == 0) return 0;

        int val = items[N - 1][0];
        int wt = items[N - 1][1];
        if (wt <= W) {
            int include = val + knapsack01(items, W - wt, N - 1);
            int exclude = knapsack01(items, W, N - 1);
            return Math.max(exclude, include);
        } else return knapsack01(items, W, N - 1);
    }

    static double fractionalKnapsack(int[][] items, int K) {

        Arrays.sort(items, (a, b) -> {
            var r1 = a[0] / a[1];
            var r2 = b[0] / b[1];

            return Double.compare(r2, r1); // descending
        });

        double maxVal = 0.0;

        for (int[] item : items) {

            int val = item[0];
            int wt = item[1];

            if (wt <= K) {
                maxVal += val;
                K -= wt;
            } else {
                maxVal += ((double) val / wt) * K;
                break;
            }
        }

        return maxVal;
    }
}
