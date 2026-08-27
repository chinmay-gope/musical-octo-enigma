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
//        shortestUnsortedSubArr(arr);
//
//        printPascal(6);
//        System.out.println();
//
//        findKthElement(5, 3);
//        findKthElement(4, 2);
//        System.out.println();
//
//        printNthRow(5);
//        printNthRow(4);
//
//        pascalTriangle(5);

        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println("threeSumClosest: " + threeSumClosest(nums, target));
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

    private static void printPascal(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            int num = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    //Find Kth element in nth row in Pascal triangle
    private static void findKthElement(int row, int k) {
        int result = 1;
        for (int j = 0; j < k; j++) {
            result = result * (row - j) / (j + 1);
        }
        System.out.println("Find Kth element in nth row in Pascal triangle:");
        System.out.println("result = " + result);
    }

    /*
                  1
                 1 1
                1 2 1
               1 3 3 1
              1 4 6 4 1
     */

    // n = 4 : [1 4 6 4 1]
    private static void printNthRow(int n) {
        int num = 1;
        int[] resArr = new int[n + 1];

        System.out.print("printNthRow: ");
        resArr[0] = num;
        for (int j = 0; j < n; j++) {
            num = num * (n - j) / (j + 1);
            resArr[j + 1] = num;
        }

        System.out.println(Arrays.toString(resArr));
    }

    private static void pascalTriangle(int n) {
        int[][] arr = new int[n][n];

        System.out.println("\npascalTriangle: ");
        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;


            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
//            for (int k = 0; k < n - i; k++) {
//                System.out.print(" ");
//            }
            for (int j = 0; j < n; j++) {

                if (arr[i][j] != 0) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println(Arrays.deepToString(arr));
    }

    //    Input: nums = [-1,2,1,-4], target = 1
    //    Output: 2
    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: sort the array
        int closest = nums[0] + nums[1] + nums[2]; // initialize with first 3 elements

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // update closest if this sum is nearer to target
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    left++; // need a bigger sum
                } else if (sum > target) {
                    right--; // need a smaller sum
                } else {
                    return sum; // exact match
                }
            }
        }
        return closest;
    }
}
