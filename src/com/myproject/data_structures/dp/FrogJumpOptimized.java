package com.myproject.data_structures.dp;

public class FrogJumpOptimized {
    static void main(String[] args) {
        int[] heights1 = {30, 20, 50, 10, 40};
        System.out.println("Frog Jump Optimized result = " + minCost(heights1)); // 30

        int[] heights2 = {20, 30, 40, 20};
        System.out.println("Frog Jump Optimized result = " + minCost(heights2)); // 20
    }

    // Space optimized version
    private static int minCost(int[] ht) {
        int n = ht.length;
        if (n == 1) return 0;

        int cost2 = 0; // cost to reach stair 0
        int cost1 = Math.abs(ht[1] - ht[0]); // cost to reach stair 1
        int curr = cost1;

        for (int i = 2; i < n; i++) {
            int fromPrev = cost1 + Math.abs(ht[i] - ht[i - 1]);
            int fromPrevPrev = cost2 + Math.abs(ht[i] - ht[i - 2]);

            curr = Math.min(fromPrev, fromPrevPrev);

            cost2 = cost1;
            cost1 = curr;
        }

        return curr;
    }
}
