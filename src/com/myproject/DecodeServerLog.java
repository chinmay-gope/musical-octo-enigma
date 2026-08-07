package com.myproject;

import java.util.Stack;

public class DecodeServerLog {

    private static void printLog(DecodeServerLog decoder, String testCase) {
        String result = decoder.decode(testCase);
        System.out.println("Encoded : " + testCase);
        System.out.println("Decoded : " + result);
        System.out.println();
    }

    static void main(String[] args) {
        DecodeServerLog decoder = new DecodeServerLog();

        printLog(decoder, "3[a]2[bc]");      // aaabcbc
        printLog(decoder, "2[a3[c]]");       // acccaccc
        printLog(decoder, "3[a2[c]]");       // accaccacc
        printLog(decoder, "10[a]");          // aaaaaaaaaa
        printLog(decoder, "2[abc]3[cd]ef");  // abcabccdcdcdef
    }

    private String decode(String encodedString) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : encodedString.toCharArray()) {

            if (Character.isDigit(ch)) {
                // Build multi-digit number
                k = k * 10 + (ch - '0');
//                System.out.println("Digit: " + ch + ", Current k: " + k);

            } else if (ch == '[') {
                // Save current state
//                System.out.println("Encountered [: Pushing current k: " + k + ", Current string: " + current);
                counts.push(k);
                resultStack.push(current);

                current = new StringBuilder();
                k = 0;

            } else if (ch == ']') {
                // Decode current section
//                System.out.println("Encountered ]: Current string before repeat: " + current);
                StringBuilder temp = current;
                current = resultStack.pop();

                int repeatTimes = counts.pop();

//                System.out.println("Repeating: " + temp + ", Times: " + repeatTimes);
                current.repeat(temp, repeatTimes);
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}
