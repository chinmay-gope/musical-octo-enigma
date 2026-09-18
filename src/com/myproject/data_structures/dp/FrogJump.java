package com.myproject.data_structures.dp;

public class FrogJump implements FrogJumpSolver {
    static void main() {
        FrogJumpSolver solver = new FrogJump();
        System.out.println("Frog Jump result ht1 = " + solver.minCost(FrogJumpSolver.ht1)); // 30
        System.out.println("Frog Jump result ht2 = " + solver.minCost(FrogJumpSolver.ht2)); // 20
    }

    @Override
    public int minCost(int[] ht) {
        int n = ht.length;
        if (n == 1) return 0;

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(ht[1] - ht[0]);

        for (int i = 2; i < n; i++) {
            int jump1 = dp[i - 1] + Math.abs(ht[i] - ht[i - 1]);
            int jump2 = dp[i - 2] + Math.abs(ht[i] - ht[i - 2]);
            dp[i] = Math.min(jump1, jump2);
        }
        return dp[n - 1];
    }
}
