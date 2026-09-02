package com.myproject.introduction.learning;

import java.util.Stack;

public class DecodeServerLog {

    private static void printLog(DecodeServerLog decoder, String testCase) {
        try {
            String result = decoder.decode(testCase);
            System.out.println("Encoded : " + testCase);
            System.out.println("Decoded : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Encoded : " + testCase);
            System.out.println("Error    : " + e.getMessage());
        }
        System.out.println();
    }

    static void main(String[] args) {
        DecodeServerLog decoder = new DecodeServerLog();

        printLog(decoder, "3[a]2[bc]");      // aaabcbc
        printLog(decoder, "2[a3[c]]");       // accacc
        printLog(decoder, "3[a2[b]");        // malformed (missing ']')
        printLog(decoder, "abc]");           // malformed (extra ']')
        printLog(decoder, "2[]");            // malformed (empty repeat)
    }

    private String decode(String encodedString) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : encodedString.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');

            } else if (ch == '[') {
                if (k == 0) {
                    throw new IllegalArgumentException("Missing repeat count before '['");
                }
                counts.push(k);
                resultStack.push(current);

                current = new StringBuilder();
                k = 0;

            } else if (ch == ']') {
                if (counts.isEmpty() || resultStack.isEmpty()) {
                    throw new IllegalArgumentException("Unmatched closing bracket ']'");
                }

                String temp = current.toString();
                if (temp.isEmpty()) {
                    throw new IllegalArgumentException("Empty repeat block [] is not allowed");
                }

                current = resultStack.pop();
                int repeatTimes = counts.pop();
                current.append(temp.repeat(repeatTimes));

            } else {
                current.append(ch);
            }
        }

        // If stacks are not empty, brackets were unmatched
        if (!counts.isEmpty() || !resultStack.isEmpty()) {
            throw new IllegalArgumentException("Unmatched opening bracket '['");
        }

        return current.toString();
    }
}
