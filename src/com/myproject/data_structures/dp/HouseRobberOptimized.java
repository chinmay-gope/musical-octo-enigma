package com.myproject.data_structures.dp;

public class HouseRobberOptimized implements HouseRobberSolver {
    static void main() {
        HouseRobberSolver solver = new HouseRobberOptimized();
        System.out.println("House Robber I result = " + solver.robLinear(HouseRobberSolver.nums1));
        System.out.println("House Robber II result = " + solver.robCircular(HouseRobberSolver.nums2));
    }

    @Override
    public int robLinear(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
