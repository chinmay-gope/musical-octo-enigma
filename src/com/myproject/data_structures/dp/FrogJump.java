package com.myproject.data_structures.dp;

public class FrogJump {
    static void main(String[] args) {
        int[] heights1 = {30, 20, 50, 10, 40};
        System.out.println("Frog Jump result = " + minCost(heights1)); // 30

        int[] heights2 = {20, 30, 40, 20};
        System.out.println("Frog Jump result = " + minCost(heights2)); // 20
    }

    // DP array version
    private static int minCost(int[] ht) {
        int n = ht.length;
        if (n == 1) return 0;

        int[] dp = new int[n]; // dp[i] : min cost to reach i-th stair
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
