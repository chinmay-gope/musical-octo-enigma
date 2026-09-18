package com.myproject.data_structures.dp;

public interface HouseRobberSolver {
    // Shared test arrays
    int[] nums1 = {2, 7, 9, 3, 1};
    int[] nums2 = {2, 7, 9, 3, 1};

    int robLinear(int[] nums);

    default int robCircular(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int case1 = robRange(nums, 0, n - 2);
        int case2 = robRange(nums, 1, n - 1);
        return Math.max(case1, case2);
    }

    default int robRange(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
