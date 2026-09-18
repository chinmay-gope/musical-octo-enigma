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

     /* int[] dp = new int[n]; // dp[i] : min cost to reach i'th stair
        dp[0] = 0;
        dp[1] = Math.abs(ht[0] - ht[1]); */

        int cost2 = 0; // cost to reach stair 0
        int cost1 = Math.abs(ht[0] - ht[1]); // cost to reach stair 1
        int curr = cost1;

        for (int i = 2; i < n; i++) {
/*          int jump1 = dp[i - 1] + Math.abs(ht[i] - ht[i - 1]);
            int jump2 = dp[i - 2] + Math.abs(ht[i] - ht[i - 2]);
            dp[i] = Math.min(jump1, jump2);*/

            int from1 = cost1 + Math.abs(ht[i] - ht[i - 1]);
            int from2 = cost2 + Math.abs(ht[i] - ht[i - 2]);

            curr = Math.min(from1, from2);

            cost2 = cost1;
            cost1 = curr;
        }

        return curr;
    }

}
