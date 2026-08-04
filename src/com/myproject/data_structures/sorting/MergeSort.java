package com.myproject.data_structures.sorting;

import java.util.Arrays;

public class MergeSort implements Sort {

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

        int i = l;
        int j = m + 1;
        int k = 0;

        while (i <= m && j <= r) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m)
            temp[k++] = arr[i++];

        while (j <= r)
            temp[k++] = arr[j++];

        for (i = l, k = 0; i <= r; i++, k++)
            arr[i] = temp[k];
    }

    static void main(String[] args) {

        int[] arr = {4, 2, 8, 1, 5};

        new MergeSort().sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }

    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
}
