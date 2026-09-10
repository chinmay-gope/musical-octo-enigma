package com.myproject.introduction.learning;

import java.util.Arrays;

public class GUT {
    static void main() {
        int[] arr = {1, 6, 4, 8, 5, 9, 6};
        int k = 2;

        int kthMax = getKthMax(arr, k);
        System.out.println("Kth Max Number is : " + kthMax);

        System.out.println("_____________K DISTINCT MAX________________");

        k = 3;
        kthMax = getKthDistinctMax(arr, k);
        System.out.println("Kth Distinct Max Number is : " + kthMax);

        k = 4;
        kthMax = getKthDistinctMax(arr, k);
        System.out.println("Kth Distinct Max Number is : " + kthMax);

        System.out.println("_____________WINDOW SUM________________");

        k = 2;
        int[] windowSum = circularWindowSum(new int[]{5, 7, 1, 4}, k);
        System.out.println(Arrays.toString(windowSum));

        k = 3;
        windowSum = circularWindowSum(new int[]{1, 2, 3, 4, 5, 6}, k);
        System.out.println(Arrays.toString(windowSum));

        System.out.println("_____________REVERSE OBJ ARR________________");

        Object[] objectArr = {1, '2' + 3, 'A', "Hello", new Object[]{4, 5, new Object[]{6, null, 8}}};
        reverseObjectArray(objectArr);
        System.out.println(Arrays.deepToString(objectArr));
    }

    private static void reverseObjectArray(Object[] arr) {
        int st = 0, end = arr.length - 1;

//        {1,
//        '2' + 3,
//        'A',
//        "Hello",
//          new Object[]{
//              4, 5,
//                  new Object[]{
//                      6, null, 8
//             }
//         }};
        while (st < end) {
            Object temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }

        for (Object el : arr) {
            if (el instanceof Object[]) {
                reverseObjectArray((Object[]) el);
            }
        }

    }

    private static int getKthMax(int[] arr, int k) {
        if (k <= 0 || k > arr.length) return -1;

        for (int i = 0; i < k; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

//            System.out.println(Arrays.toString(arr));
        }

        return arr[k - 1];
    }

    private static int[] circularWindowSum(int[] arr, int k) {
        int n = arr.length;
        if (k <= 0 || k > n) return new int[0];

        int[] result = new int[n];
        int sum = 0;

        // calc init sum
        for (int i = 1; i <= k; i++) {
            sum += arr[i % n];
        }
        result[0] = sum;


        for (int i = 1; i < n; i++) {
            int out = arr[i % n];
            int in = arr[(i + k) % n];

            sum += in - out;
            result[i] = sum;
        }

        return result;
    }

    private static int getKthDistinctMax(int[] arr, int k) {
        int lastMax = Integer.MAX_VALUE;
        int distinctCount = 0;

        while (distinctCount < k) {
            int currentMax = Integer.MIN_VALUE;

            // find the largest element smaller than lastMax
            for (int value : arr) {
                if (value < lastMax && value > currentMax) {
                    currentMax = value;
                }
            }

            if (currentMax == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Not enough distinct elements for k=" + k);
            }

            distinctCount++;
            lastMax = currentMax;

            // when we reach k-th distinct max
            if (distinctCount == k) {
                return currentMax;
            }
        }

        throw new IllegalArgumentException("Unexpected flow");
    }
}
