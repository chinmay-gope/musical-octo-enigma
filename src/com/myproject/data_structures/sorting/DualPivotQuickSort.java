package com.myproject.data_structures.sorting;

import java.util.Arrays;

public class DualPivotQuickSort implements Sort {

    private static void quickSort(int[] arr, int low, int high) {

        while (low < high) {

            // Partition
            if (arr[low] > arr[high]) {
                swap(arr, low, high);
            }

            int pivot1 = arr[low];
            int pivot2 = arr[high];

            int lt = low + 1;
            int gt = high - 1;
            int i = low + 1;

            while (i <= gt) {

                if (arr[i] < pivot1) {
                    swap(arr, i++, lt++);
                } else if (arr[i] > pivot2) {
                    swap(arr, i, gt--);
                } else {
                    i++;
                }
            }

            swap(arr, low, --lt);
            swap(arr, high, ++gt);

            int leftSize = lt - low;
            int middleSize = gt - lt - 1;
            int rightSize = high - gt;

            // Continue with the largest partition
            if (leftSize >= middleSize && leftSize >= rightSize) {

                quickSort(arr, lt + 1, gt - 1);
                quickSort(arr, gt + 1, high);

                high = lt - 1;      // iterate on left

            } else if (middleSize >= leftSize && middleSize >= rightSize) {

                quickSort(arr, low, lt - 1);
                quickSort(arr, gt + 1, high);

                low = lt + 1;
                high = gt - 1;      // iterate on middle

            } else {

                quickSort(arr, low, lt - 1);
                quickSort(arr, lt + 1, gt - 1);

                low = gt + 1;       // iterate on right
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void main() {

        int[] arr = {24, 8, 42, 75, 29, 77, 38, 57};

        DualPivotQuickSort sort = new DualPivotQuickSort();
        sort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Override
    public String getName() {
        return "Dual Pivot Quick Sort";
    }

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
}
