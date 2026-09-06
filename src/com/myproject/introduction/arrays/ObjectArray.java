package com.myproject.introduction.arrays;

import java.util.*;

public class ObjectArray {

    void main() {
        Object[] arr = {
                1, '2' + 3,
                'A', "Hello",
                new Object[]{4, 5, new Object[]{6, null, 8}}
        };

        reverseObject(arr);
        System.out.println("Reverse Object Array = " + Arrays.deepToString(arr));

        reverseOnlyIntegers(arr);
    }

    private void printArray(Object[] arr) {
        for (Object el : arr) {

            if (el instanceof Object[]) {
                printArray((Object[]) el);
            } else {
                System.out.print(el + " ");
            }
        }
        System.out.println();
    }

    private void reverseObject(Object[] arr) {
        int st = 0, end = arr.length - 1;

        while (st < end) {
            Object temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }

        // Now recurse into nested arrays
        for (Object el : arr) {
            if (el instanceof Object[]) {
                reverseObject((Object[]) el);
            }
        }
    }

    private void reverseOnlyIntegers(Object[] arr) {
        // Step 1: Collect all integers
        List<Integer> ints = new ArrayList<>();
        collectIntegers(arr, ints);

        // Step 2: Reverse the list
        Collections.reverse(ints);

        // Step 3: Put them back into the original array
        putBackIntegers(arr, ints.iterator());

        System.out.println("Reverse only Integers = " + Arrays.deepToString(arr));

    }

    private void collectIntegers(Object[] arr, List<Integer> ints) {
        for (Object el : arr) {
            if (el instanceof Object[]) {
                collectIntegers((Object[]) el, ints);
            } else if (el instanceof Integer) {
                ints.add((Integer) el);
            }
        }
    }

    private void putBackIntegers(Object[] arr, Iterator<Integer> it) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof Object[]) {
                putBackIntegers((Object[]) arr[i], it);
            } else if (arr[i] instanceof Integer) {
                arr[i] = it.next(); // replace with reversed integer
            }
        }
    }

}
