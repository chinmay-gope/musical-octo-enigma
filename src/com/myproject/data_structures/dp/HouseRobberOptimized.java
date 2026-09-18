package com.myproject.data_structures.dp;

public class HouseRobberOptimized {
    static void main(String[] args) {
        int[] nums1 = {2, 7, 9, 3, 1};
        System.out.println("House Robber I result = " + robLinear(nums1));

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("House Robber II result = " + robCircular(nums2));
    }

    // ---------------- House Robber I ----------------
    public static int robLinear(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = nums[0];                      // dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]);   // dp[i-1]

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // ---------------- House Robber II ----------------
    public static int robCircular(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: Rob houses from 0 to n-2 (exclude last)
        int case1 = robRange(nums, 0, n - 2);
        // Case 2: Rob houses from 1 to n-1 (exclude first)
        int case2 = robRange(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private static int robRange(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
