package com.myproject.introduction.arrays;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    private static final Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    static void main() {
        Test1 t = new Test1();

        int closestNumber = t.findClosestNumber(new int[]{2, -1, 1});
        System.out.println("closestNumber = " + closestNumber);

        System.out.println(t.mergeAlternately("abc", "pqr"));

        String[] tests = {"III", "LVI", "MCMXCIX", "XCIX", "VXCIX"};

        for (String test : tests) {
            try {
                System.out.println("t.romanToInt(\"" + test + "\") = " + t.romanToInt(test));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public int findClosestNumber(int[] nums) {
        int closest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

            if (Math.abs(val) < Math.abs(closest) || (Math.abs(val) == Math.abs(closest) && val > closest)) {
                closest = val;
            }
        }

        return closest;
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }

    public int romanToInt(String s) {
        if (!isValidRoman(s)) {
            throw new IllegalArgumentException("Invalid Roman numeral: " + s);
        }

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = romanMap.get(s.charAt(i));

            // If next value is larger, subtract it
            if (i + 1 < s.length() && value < romanMap.get(s.charAt(i + 1))) {
                sum -= value;
            } else {
                sum += value;
            }
        }

        return sum;
    }

    private boolean isValidRoman(String s) {
        for (char c : s.toCharArray()) {
            if (!romanMap.containsKey(c)) return false;
        }

        // Regex for valid Roman numerals (covers repetition + subtractive rules)
        String romanRegex = "^M{0,3}(CM|CD|D?C{0,3})" + "(XC|XL|L?X{0,3})" + "(IX|IV|V?I{0,3})$";

        return s.matches(romanRegex);
    }
}
