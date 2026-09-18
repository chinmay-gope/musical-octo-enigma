package com.myproject.data_structures.dp;

public class HouseRobber implements HouseRobberSolver {
    static void main() {
        HouseRobberSolver solver = new HouseRobber();
        System.out.println("House Robber I result = " + solver.robLinear(HouseRobberSolver.nums1));
        System.out.println("House Robber II result = " + solver.robCircular(HouseRobberSolver.nums2));
    }

    @Override
    public int robLinear(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
