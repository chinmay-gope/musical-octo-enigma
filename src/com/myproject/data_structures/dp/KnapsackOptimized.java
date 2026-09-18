package com.myproject.data_structures.dp;

import java.util.Arrays;

public class KnapsackOptimized implements KnapsackSolver {
    static void main(String[] args) {
        KnapsackSolver solver = new KnapsackOptimized();

        IO.println("Fractional Knapsack result = " + solver.fractionalKnapsack(KnapsackSolver.items1, KnapsackSolver.K1));
        IO.println("Knapsack01 Recursion = " + solver.knapsack01_Rec(KnapsackSolver.items2, KnapsackSolver.K2));
        IO.println("Knapsack01 MemoizationDP = " + solver.knapsack01_MemoDP(KnapsackSolver.items2, KnapsackSolver.K2));
        IO.println("Knapsack01 TabulationDP (Optimized) = " + solver.knapsack01_TabDP(KnapsackSolver.items2, KnapsackSolver.K2));
    }

    @Override
    public int knapsack01_Rec(int[][] items, int W) {
        // Recursion is inherently exponential, not optimized
        return knapsack01(items, W, items.length);
    }

    @Override
    public int knapsack01_MemoDP(int[][] items, int W) {
        // Same as full version, included for completeness
        int[][] memo = new int[items.length + 1][W + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return knapsack01(items, W, items.length, memo);
    }

    @Override
    public int knapsack01_TabDP(int[][] items, int W) {
        // Space optimized: 1D DP array
        int[] dp = new int[W + 1];
        for (int[] item : items) {
            int val = item[0];
            int wt = item[1];
            // reverse loop to avoid overwriting states prematurely
            for (int j = W; j >= wt; j--) {
                dp[j] = Math.max(dp[j], val + dp[j - wt]);
            }
        }
        return dp[W];
    }

    @Override
    public double fractionalKnapsack(int[][] items, int K) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b[0] / b[1], (double) a[0] / a[1]));
        double maxVal = 0.0;
        for (int[] item : items) {
            int val = item[0], wt = item[1];
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

    // Helpers
    private int knapsack01(int[][] items, int W, int N) {
        if (N == 0 || W == 0) return 0;
        int val = items[N - 1][0], wt = items[N - 1][1];
        if (wt <= W) {
            int include = val + knapsack01(items, W - wt, N - 1);
            int exclude = knapsack01(items, W, N - 1);
            return Math.max(exclude, include);
        } else return knapsack01(items, W, N - 1);
    }

    private int knapsack01(int[][] items, int W, int N, int[][] dp) {
        if (N == 0 || W == 0) return 0;
        if (dp[N][W] != -1) return dp[N][W];
        int val = items[N - 1][0], wt = items[N - 1][1];
        if (wt <= W) {
            int include = val + knapsack01(items, W - wt, N - 1, dp);
            int exclude = knapsack01(items, W, N - 1, dp);
            return dp[N][W] = Math.max(exclude, include);
        } else return dp[N][W] = knapsack01(items, W, N - 1, dp);
    }
}
