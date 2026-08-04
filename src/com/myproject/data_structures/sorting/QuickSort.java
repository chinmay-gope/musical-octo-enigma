package com.myproject.data_structures.sorting;

public class QuickSort implements Sort {

    private static void quickSort(int[] arr, int low, int high) {

        while (low < high) {

            int pivot = partition(arr, low, high);

            // Left partition is smaller
            if (pivot - low < high - pivot) {

                quickSort(arr, low, pivot - 1);

                low = pivot + 1;      // continue with right partition
            }
            // Right partition is smaller
            else {

                quickSort(arr, pivot + 1, high);

                high = pivot - 1;     // continue with left partition
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
}
