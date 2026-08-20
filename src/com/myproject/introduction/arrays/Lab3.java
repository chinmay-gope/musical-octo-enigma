package com.myproject.introduction.arrays;

public class Lab3 {
    static void printSubarrays(int[] arr) {
        int n = arr.length;
        for (int st = 0; st < n; st++) {
            for (int end = st; end < n; end++) {
                System.out.print("[");
                for (int k = st; k <= end; k++) {
                    System.out.print(arr[k]);
                    if (k < end) System.out.print(", ");
                }
                System.out.println("]");
            }
        }
    }

    void main() {
        int[] numArr = {-5, -2, -1, -5};

        int[] numArr2 = {-2, 1, 3, 4, -1, 2, 1, -5, 4};

        int maxSum = kadanesAlg(numArr);
        System.out.println("maxSum = " + maxSum);

        maxSum = kadanesAlg(numArr2);
        System.out.println("maxSum = " + maxSum);


        printSubarrays(new int[]{-5, -2, -1, -5});
    }

    int kadanesAlg(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            currSum += num;

            maxSum = Math.max(maxSum, currSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}
