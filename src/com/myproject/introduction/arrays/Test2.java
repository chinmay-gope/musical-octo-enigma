package com.myproject.introduction.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Test2 {

    static void main() {

        int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSubArrayWindow(array, k);
        System.out.println(Arrays.toString(result));

        result = maxSubArrayWindow2(array, k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] maxSubArrayWindow2(int[] array, int k) {
        int[] result = new int[array.length - k + 1];

        for (int i = 0; i <= array.length - k; i++) {

            int max = array[i];

            for (int j = i; j < i + k; j++) {
                if (array[j] > max) {
                    max = array[j];
                }
            }

            result[i] = max;
        }

        return result;
    }

    // Sliding window maximum
    private static int[] maxSubArrayWindow(int[] array, int k) {
        if (array == null || k <= 0 || k > array.length) {
            return new int[0];
        }

        int[] result = new int[array.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < array.length; i++) {

            // Remove indices that are outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            // Remove elements smaller than the current element
            // because they can never become maximum
            while (!deque.isEmpty()
                    && array[deque.peekLast()] <= array[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            // Window is completely formed
            if (i >= k - 1) {
                result[i - k + 1] = array[deque.getFirst()];
            }
        }

        return result;
    }
}
