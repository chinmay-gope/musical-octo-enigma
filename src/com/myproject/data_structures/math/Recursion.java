package com.myproject.data_structures.math;


public class Recursion {
    static void main() {

    }

    // Direct Recursion
    void print(int n) {
        if (n == 0) return;

        System.out.println(n);
        print(n - 1);
    }

    // Mutual Recursion
    void even(int n) {
        if (n == 0) {
            System.out.println("Even");
            return;
        }
        odd(n - 1);
    }

    void odd(int n) {
        if (n == 0) {
            System.out.println("Odd");
            return;
        }
        even(n - 1);
    }

    /* Tail Recursion
     The recursive call is the last operation.
     Nothing happens after the recursive call returns. */

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    /* Head Recursion
    Recursive call happens before any processing.*/

    void print2(int n) {
        if (n == 0) return;

        print2(n - 1);
        System.out.println(n);
    }

    //  Tree (Multiple) Recursion

    int fib(int n) {
        if (n <= 1) return n;

        return fib(n - 1) + fib(n - 2);
    }

    // Linear Recursion

    void reverse(int n) {
        if (n == 0) return;
        reverse(n - 1);
    }

    /* Nested Recursion
    The recursive call is used as an argument to another recursive call.*/

    int f(int n) {
        if (n > 100) return n - 10;

        //    Known as the McCarthy 91 Function.
        return f(f(n + 11));
    }

    // Binary Recursion
    void preorder(Node root) {
        if (root == null) return;

        preorder(root.left);
        preorder(root.right);
    }

    private static class Node {
        Node left;
        Node right;
    }

}
