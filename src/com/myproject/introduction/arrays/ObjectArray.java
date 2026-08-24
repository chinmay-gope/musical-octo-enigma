package com.myproject.introduction.arrays;

public class ObjectArray {

    void main() {
        Object[] arr = {
                1, '2' + 3,
                'A', "Hello",
                new Object[]{4, 5, new Object[]{6, null, 8}}
        };

        printArray(arr);
        System.out.println("length = " + arr.length);
    }

    private void printArray(Object[] arr) {
        for (Object el : arr) {

            if (el instanceof Object[]) {
                printArray((Object[]) el);
            } else {
                System.out.println(el);
            }
        }
    }

}
