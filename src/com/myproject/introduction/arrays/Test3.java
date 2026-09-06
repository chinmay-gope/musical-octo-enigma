package com.myproject.introduction.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test3 {
    static void main() {
        int[] nums1 = {1, 6, 4, 8, 5, 9, 6};
        System.out.println(getKthMaxEl(nums1, 3));

        int[] nums2 = {10, 20, 15, 5, 25};
        System.out.println(getKthMaxEl(nums2, 2));

        getKthMaxElSelSort(nums1, 3);
        getKthMaxElSelSort(nums2, 2);

        int[] windowSum = circularWindowSum(nums2, 2);
        System.out.println(Arrays.toString(windowSum));

        windowSum = circularWindowSum(nums2, 3);
        System.out.println(Arrays.toString(windowSum));
    }

    private static Integer getKthMaxEl(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    private static void getKthMaxElSelSort(int[] nums, int k) {
        if (k <= 0 || k > nums.length) return;

        // Perform selection sort only for k iterations
        for (int i = 0; i < k; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[maxIdx]) {
                    maxIdx = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[maxIdx];
            nums[maxIdx] = temp;
        }

        System.out.println("Kth max element is = " + nums[k - 1]);
    }


    private static int[] circularWindowSum(int[] arr, int k) {
        int n = arr.length;

        if (k <= 0 || k > n) {
            return new int[0];
        }

        int[] result = new int[n];

        int sum = 0;

        for (int j = 1; j <= k; j++) {
            sum += arr[j % n];
        }

        result[0] = sum;

        // Slide the circular window
        for (int i = 1; i < n; i++) {
            int outgoing = arr[i % n];
            int incoming = arr[(i + k) % n];

            sum = sum - outgoing + incoming;

            result[i] = sum;
        }

        return result;
    }
}
