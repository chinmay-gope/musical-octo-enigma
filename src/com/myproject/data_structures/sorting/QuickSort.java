package com.myproject.data_structures.sorting;

import java.util.Arrays;

public class QuickSort {
    static void main() {
        int[] arr = {4, 2, 8, 1, 5};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high]; // last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
