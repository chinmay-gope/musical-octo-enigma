package com.myproject.introduction.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Input : [0, 1, 0, 3, 12]
// Output : [1, 3, 12, 0, 0]
public class Lab1 {
    void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12, 8};
//        arr = new int[]{0, 3, 2, 0, 7, 7, 6, 0};
//        arr = new int[]{1, 0, 1, 0, 1};
//        arr = new int[]{1, 2, 3, 4, 5};
        moveZerosToEnd(arr);

        int[] dupArr = {2, 4, 2, 3, 2, 4, 4};
        removeDuplicates(dupArr);
        printDuplicates(dupArr);
        printDuplicates2(dupArr);
    }

    void moveZerosToEnd(int[] arr) {
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        // fill remaining positions with zeros
        while (index < arr.length) {
            arr[index++] = 0;
        }

//        for (int j : arr) {
//            if (j != 0) {
//                resultArr[index++] = j;
//            }
//        }

        System.out.println("arr = " + Arrays.toString(arr));
    }


    void removeDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean find = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    void printDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        System.out.println("Duplicates = " + duplicates);
    }

    void printDuplicates2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 1;

            // Count occurrences of arr[i]
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            boolean alreadyPrinted = false;
            for (int k = 0; k < i; k++) {
                if (arr[k] == arr[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (count > 1 && !alreadyPrinted) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
