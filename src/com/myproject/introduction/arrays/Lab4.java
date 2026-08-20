package com.myproject.introduction.arrays;

public class Lab4 {
    static void main() {
        int[][] arr = {{1, 2}, {3, 4}};
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(sumOfEl(arr));

        minMax(arr2);
    }

    static int sumOfEl(int[][] arr) {
        int sum = 0;
        for (int[] arr1D : arr) {
            for (int el : arr1D) {
                sum += el;
            }
        }
        return sum;
    }

    static void minMax(int[][] arr) {
        int min = arr[0][0], max = arr[0][0];
        for (int[] arr1D : arr) {
            for (int el : arr1D) {
                max = Math.max(max, el);
                min = Math.min(min, el);
            }
        }

        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
}
