package com.myproject.pattern;

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

    void butterfly(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= 2 * (row - i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = row - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= 2 * (row - i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void main() {
        Scanner sc = new Scanner(System.in);

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


        System.out.println("Enter n value (Inverted Half Triangle): ");
        N = sc.nextInt();
        invertedHalfPyramid(N);
        System.out.println();

        System.out.println("Enter n value (Inverted Triangle Int): ");
        N = sc.nextInt();
        invertedTriangleInt(N);
    }
}
