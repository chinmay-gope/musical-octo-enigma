package com.myproject.data_structures.sorting;

import java.util.Arrays;

public class MergeSort {

    static void main() {
        int[] arr = {4, 2, 8, 1, 5};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }

            while (i <= m) {
                temp[k++] = arr[i++];
            }

            while (j <= r) {
                temp[k++] = arr[j++];
            }

            for (i = l, k = 0; i <= r; i++, k++) {
                arr[i] = temp[k];
            }
        }
    }
}