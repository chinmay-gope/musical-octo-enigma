package com.myproject.introduction.arrays;

import java.util.Arrays;

public class Lab3Extras {
    static void main() {

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Transpose:");
        transpose(arr);

        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Rotate 90deg");
        rotate90ClockWise(arr2);

        System.out.println("Rotate Anti 90deg");
        rotate90AntiClockWise(arr2);

        new Lab3Extras().inplaceOps();
    }

    private static void rotate90AntiClockWise(int[][] arr) {
        int n = arr.length;
        int[][] rotatedArray = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArray[n - j - 1][i] = arr[i][j];
            }
        }

        printArr(rotatedArray);
    }

    private static void rotate90ClockWise(int[][] arr) {
        int n = arr.length;
        int[][] rotatedArray = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArray[j][n - i - 1] = arr[i][j];
            }
        }

        printArr(rotatedArray);
    }

    static void transpose(int[][] arr) {
//        int[][] transpose = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++)
//                transpose[j][i] = arr[i][j];

            // inplace transposed
            for (int j = i + 1; j < arr.length; j++) {
//                int temp = arr[i][j];
//                arr[i][j] = arr[j][i];
//                arr[j][i] = temp;
                swap(arr, i, j, j, i);
            }
        }

        // using Arrays.deepToString()
        System.out.println(Arrays.deepToString(arr));
//        printArr(arr);
    }

    static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
//        System.out.println(
//        Arrays.deepToString(arr);
//        );
    }

    // General-purpose swap for any two positions
    private static void swap(int[][] arr, int i1, int j1, int i2, int j2) {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }

    void inplaceOps() {
        System.out.println("\nInplace transformations:");

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("rotate90ClockWiseInPlace");
        rotate90ClockWiseInPlace(arr);

        // Reset arr before anti-clockwise
        arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("rotate90AntiClockWiseInPlace");
        rotate90AntiClockWiseInPlace(arr);
    }

    private void rotate90ClockWiseInPlace(int[][] arr) {
        int n = arr.length;

        transpose(arr);

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int st = 0, end = n - 1;
            while (st < end) {
//                int temp = arr[i][st];
//                arr[i][st] = arr[i][end];
//                arr[i][end] = temp;
                swap(arr, i, st, i, end);
                st++;
                end--;
            }
        }

        printArr(arr);
    }

    private void rotate90AntiClockWiseInPlace(int[][] arr) {
        int n = arr.length;

        transpose(arr);

        // Step 2: Reverse each column
        for (int j = 0; j < n; j++) {
            int st = 0, end = n - 1;
            while (st < end) {
                swap(arr, st, j, end, j);
                st++;
                end--;
            }
        }

        printArr(arr);
    }

}
