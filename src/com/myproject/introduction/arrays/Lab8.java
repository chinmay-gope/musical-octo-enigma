package com.myproject.introduction.arrays;

import java.util.Arrays;

public class Lab8 {
    static void main() {
        int[][] ranges = new int[][]{{1, 6}, {2, 3}, {0, 5}, {1, 8}};

        overlappingRanges(ranges);

        System.out.println("\nOverlapping ranges:");
        overlappingRanges2(ranges);
    }

    /*
     * ip : [(1,6) (2,3) (0,5) (1, 8)]
     * op : 0 1 0 0
     */
    static void overlappingRanges(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int found = 0;

            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;

                if (arr[i][0] > arr[j][0] &&
                        arr[i][1] < arr[j][1]) {
                    found = 1;
                    break;
                }
            }

            System.out.print(found + " ");
        }
    }

    static void overlappingRanges2(int[][] arr) {

        int n = arr.length;

        int[][] ranges = new int[n][3];

        for (int i = 0; i < n; i++) {
            ranges[i][0] = arr[i][0]; // start
            ranges[i][1] = arr[i][1]; // end
            ranges[i][2] = i;         // original index
        }

        Arrays.sort(ranges, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(b[1], a[1]);
        });

        int[] result = new int[n];

        int maxEnd = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int start = ranges[i][0];
            int end = ranges[i][1];

            if (i > 0 && start > ranges[i - 1][0] && end < maxEnd) {
                result[ranges[i][2]] = 1;
            }

            maxEnd = Math.max(maxEnd, end);
        }

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
