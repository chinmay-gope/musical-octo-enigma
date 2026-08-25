package com.myproject.introduction.arrays;

public class Lab6 {
    void main() {

        Object[][] objArr = {{1, 2, 3}, {4, 5, new int[]{10, 11}}, {6, 7, 8, 9}};

        System.out.println(objArr[2][1]);
        System.out.println(objArr[1].length);

        starPyramid(5);
        invertedStarPyramid(8);
    }

    void starPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void invertedStarPyramid(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
