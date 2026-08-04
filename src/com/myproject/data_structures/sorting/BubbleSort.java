package com.myproject.data_structures.sorting;

import java.util.Arrays;

public class BubbleSort implements Sort {

    static void main() {
        int[] arr = {4, 2, 8, 9, -1, 0};

        bubbleSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }

    @Override
    public void sort(int[] array) {
        bubbleSort(array);
    }
}
