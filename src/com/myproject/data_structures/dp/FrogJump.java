package com.myproject.data_structures.dp;

public class FrogJump {
    static void main() {
        int[] heights = {30, 20, 50, 10, 40};

        System.out.println("minCost = " + minCost(heights)); // 30

        heights = new int[]{20, 30, 40, 20};
        System.out.println("minCost = " + minCost(heights)); // 20
    }

    private static int minCost(int[] ht) {
        int n = ht.length;

        dp[0] = 0;

        for (int i = 2; i < n; i++) {
            int jump2 = dp[i - 2] + Math.abs(ht[i] - ht[i - 2]);

        }

    }

}
