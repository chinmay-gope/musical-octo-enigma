package com.myproject.introduction.arrays;

public class LAb5 {
    static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        sumOfMainDiagonal(arr); //15

        sumOfDiagonals(arr); //25

        int key = 8;
//        System.out.println("Linear Search: " + linearSearch(arr, key));
        System.out.println("Binary Search: " + binarySearch(arr, key));
    }

    static void sumOfMainDiagonal(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }

        System.out.println("sum = " + sum);
    }

    static void sumOfDiagonals(int[][] arr) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i][i]; // PD

            //for SD sum check i == n-j-1;

            // SD
            if (i != n - i - 1) {
                sum += arr[i][n - i - 1];
            }
        }

        System.out.println("sumOfDiagonals = " + sum);
    }

    static String linearSearch(int[][] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (key == arr[i][j]) {
                    return "(" + i + ", " + j + ")";
                }
            }
        }

        return key + " Not found";
    }


    // log(M) + log(N) = log(MN)
    // O(1) = Constant
    static boolean binarySearch(int[][] arr, int key) {
        int n = arr.length;

        int stRow = 0;
        int edRow = arr[0].length - 1;

        while (stRow <= edRow) {

            int midRow = stRow + (edRow - stRow) / 2;

            if (key >= arr[midRow][0] && key <= arr[midRow][n - 1]) {
                return searchInRow(arr, midRow, key);
            } else if (key > arr[midRow][n - 1]) {
                stRow = midRow + 1;
            } else {
                edRow = midRow - 1;
            }
        }

        return false;
    }

    private static boolean searchInRow(int[][] arr, int row, int key) {

        int start = 0;
        int end = arr[row].length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (key == arr[row][mid]) {
                System.out.println("index bs = (" + row + ", " + mid + ")");
                return true;
            } else if (key > arr[row][mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
