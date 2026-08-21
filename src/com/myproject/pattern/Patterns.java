package com.myproject.pattern;

import java.util.Arrays;
import java.util.Scanner;

public class Patterns {

    void solidRectangle(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void hollowRectangle(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 || j == 1 || i == n || j == m) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    void halfPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void invertedHalfPyramid(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void invertedHalfPyramidRotated(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    void invertedTriangle(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void invertedCentralTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            // spaces
            for (int j = 0; j < n - i; j++) {
                System.out.print("  ");
            }
            // stars
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void invertedTriangleInt(int n) {
        for (int i = n; i > 0; i--) {
            // leading spaces
            for (int s = n - i; s > 0; s--) {
                System.out.print("  ");
            }

            // numbers
            int num = n - i + 1;
            for (int j = i; j > 0; j--) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    void butterfly(int n) {

        // upper half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    void butterflyWithLessLoops(int n) {

        for (int i = 1; i <= 2 * n - 1; i++) {

            int row = i <= n ? i : 2 * n - i;
            int spaces = 2 * (n - row); // evenly distributed stars in center. (4 4)
//            spaces = 2 * (n - row) - 1; // for un-even distributed stars in center based on n/2 value. (4 3)

            for (int j = 1; j <= 2 * row + spaces; j++) {

                if (j <= row || j > row + spaces) {
                    System.out.print("* ");
//                    System.out.print(i + "," + j + " ");
//                    if (j <= row) System.out.print("_ ");
//                    if (j > row + spaces) System.out.print("> ");
                } else {
                    System.out.print("  ");
                }
            }
//            System.out.print(i + " ");
            System.out.println();
        }
    }

    void labPattern(int[][] arr) {

        int n = arr.length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[arr[0].length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (row[i] || col[j]) {
                    arr[i][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));
    }

    void main() {

        butterflyWithLessLoops(4);

        Scanner sc = new Scanner(System.in);
        labPattern(new int[][]{{1, 2, 0}, {4, 5, 6}, {0, 8, 0}});

        System.out.println("Enter row value (Butterfly): ");
        int N = sc.nextInt();
        butterfly(N);
        System.out.println();

        System.out.println("Enter n,m value (Solid Rectangle): ");
        N = sc.nextInt();
        int M = sc.nextInt();
        solidRectangle(N, M);
        System.out.println();

        System.out.println("Enter n,m value (Hollow Rectangle): ");
        N = sc.nextInt();
        M = sc.nextInt();
        hollowRectangle(N, M);
        System.out.println();

        System.out.println("Enter n value (Half Rectangle): ");
        N = sc.nextInt();
        halfPyramid(N);
        System.out.println();

        System.out.println("Enter n value (Inverted Half Rectangle): ");
        N = sc.nextInt();
        invertedHalfPyramidRotated(N);
        System.out.println();

        System.out.println("Enter n value (Inverted Triangle): ");
        N = sc.nextInt();
        invertedTriangle(N);
        System.out.println();

        System.out.println("Enter n value (Inverted Central Triangle): ");
        N = sc.nextInt();
        invertedCentralTriangle(N);
        System.out.println();

        System.out.println("Enter n value (Inverted Half Pyramid): ");
        N = sc.nextInt();
        invertedHalfPyramid(N);
        System.out.println();

        System.out.println("Enter n value (Inverted Triangle Int): ");
        N = sc.nextInt();
        invertedTriangleInt(N);
    }
}
