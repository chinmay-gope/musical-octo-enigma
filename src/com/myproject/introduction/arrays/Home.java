package com.myproject.introduction.arrays;

import java.util.Arrays;

// Given an integer array nums, find the shortest continuous subarray,
// such that sorting only that subarray makes the entire array sorted in ascending order.
public class Home {
    static void main() {

        int[] arr = {1, 2, 5, 3, 4, 0, 6, 7};
//        arr = new int[]{1, 2, 6, 4, 5, 3, 7, 8};
//        arr = new int[]{1, 2, 3, 7, 5, 6, 4, 6, 9};
        arr = new int[]{2, 6, 4, 8, 10, 9, 15};
        shortestUnsortedSubArr(arr);
    }

    private static void shortestUnsortedSubArr(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left < n - 1 && arr[left] <= arr[left + 1]) left++;

        if (left == n - 1) {
            System.out.println("Array is already sorted.");
            return;
        }

        while (right > 0 && arr[right] >= arr[right - 1]) right--;

        int[] sub = Arrays.copyOfRange(arr, left, right + 1);

        // Find min and max
        int min = sub[0];
        int max = sub[0];

        for (int x : sub) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        // Expand left
        while (left > 0 && arr[left - 1] > min) {
            left--;
        }

        // Expand right
        while (right < n - 1 && arr[right + 1] < max) {
            right++;
        }

        sub = Arrays.copyOfRange(arr, left, right + 1);

        System.out.println("Subarray: " + Arrays.toString(sub));
    }
}
