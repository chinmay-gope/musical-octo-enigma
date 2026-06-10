package com.myproject.pattern;

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

    void main() {
        solidRectangle(3, 5);
        System.out.println();

        hollowRectangle(5, 4);
        System.out.println();

        halfPyramid(3);
        System.out.println();

        invertedHalfPyramidRotated(4);
        System.out.println();

        invertedTriangle(4);
        System.out.println();

        invertedHalfPyramid(4);
        System.out.println();

        invertedTriangleInt(4);
    }
}
