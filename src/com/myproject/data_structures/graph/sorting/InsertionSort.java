package com.myproject.data_structures.graph.sorting;

import java.util.Arrays;

public class InsertionSort {
    static void main() {
        int[] arr = {4, 2, 8, 9, -1, 0};

        insertionSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
        }
    }
}
