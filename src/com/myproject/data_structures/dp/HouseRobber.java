package com.myproject.data_structures.dp;

public class HouseRobber {

    static void main() {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("rob(nums) = " + rob(nums));
        System.out.println("robOpt(nums) = " + robOpt(nums)); // 12

        System.out.println("cyclicRob(nums) = " + cyclicRob(nums)); // 11
    }

    public static int rob(int[] nums) {
/*      int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]); // max(inc, exc)
        }

        return dp[n - 1];
*/
        return rob(nums, 0, nums.length - 1);
    }

    public static int robOpt(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);
        int curr = prev2;

        for (int i = 2; i < n; i++) {
            curr = Math.max(prev1 + nums[i], prev2);
            prev1 = prev2;
            prev2 = curr;
        }

        return curr;
    }

    //    HOUSE ROBBER - 2 (houses are cyclic)
    public static int cyclicRob(int[] nums) {
        if (nums.length == 1) return nums[0];

        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(
                rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1)
        );
    }

    private static int rob(int[] nums, int st, int end) {
/*      int[] dp = new int[nums.length - 1];
        dp[0] = nums[st];
        dp[1] = Math.max(nums[st], nums[st + 1]);
*/
        int prev1 = nums[st];
        int prev2 = Math.max(nums[st], nums[st + 1]);
        int curr = prev2;

        for (int i = st + 2, j = 2; i <= end; i++, j++) {
//            dp[j] = Math.max(nums[i] + dp[j - 2], dp[j - 1]); // {inc, exc}
            curr = Math.max(prev1 + nums[i], prev2);

            prev1 = prev2;
            prev2 = curr;
        }

//        return dp[n - 2];
        return curr;
    }

}
