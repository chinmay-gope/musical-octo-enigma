package com.myproject.pattern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lab2 {
    static void main() {
        spiralPattern(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        spiralPattern(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
    }

    static void numberPattern() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("_______");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void spiralPattern(int[][] matrix) {
        List<Integer> spiral = new LinkedList<>();

        int stRow = 0, endRow = matrix.length - 1;
        int stCol = 0, endCol = matrix[0].length - 1;

        while (stRow <= endRow && stCol <= endCol) {
            // Top row
            for (int i = stCol; i <= endCol; i++)
                spiral.add(matrix[stRow][i]);

            // Right column
            for (int j = stRow + 1; j <= endRow; j++)
                spiral.add(matrix[j][endCol]);

            // Bottom row (only if it's not the same as the top row)
            if (stRow < endRow) {
                for (int i = endCol - 1; i >= stCol; i--)
                    spiral.add(matrix[endRow][i]);
            }

            // Left column (only if it's not the same as the right column)
            if (stCol < endCol) {
                for (int j = endRow - 1; j > stRow; j--)
                    spiral.add(matrix[j][stCol]);
            }

            stRow++;
            endRow--;
            stCol++;
            endCol--;
        }

        System.out.println(Arrays.toString(spiral.toArray()));
    }
}
