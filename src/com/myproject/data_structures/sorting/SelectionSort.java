package com.myproject.data_structures.sorting;

import java.util.Arrays;

public class SelectionSort {
    static void main() {
        int[] arr = {64, 25, 12, 22, 11};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
