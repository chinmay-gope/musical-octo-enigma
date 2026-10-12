package com.myproject.data_structures.math;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanConversion {

    private static final TreeMap<Integer, String> TREE_MAP = new TreeMap<>();
    private static final Map<Character, Integer> HASH_MAP = new HashMap<>();

    static {
        HASH_MAP.put('I', 1);
        HASH_MAP.put('V', 5);
        HASH_MAP.put('X', 10);
        HASH_MAP.put('L', 50);
        HASH_MAP.put('C', 100);
        HASH_MAP.put('D', 500);
        HASH_MAP.put('M', 1000);
    }

    static {
        TREE_MAP.put(1000, "M");
        TREE_MAP.put(900, "CM");
        TREE_MAP.put(500, "D");
        TREE_MAP.put(400, "CD");
        TREE_MAP.put(100, "C");
        TREE_MAP.put(90, "XC");
        TREE_MAP.put(50, "L");
        TREE_MAP.put(40, "XL");
        TREE_MAP.put(10, "X");
        TREE_MAP.put(9, "IX");
        TREE_MAP.put(5, "V");
        TREE_MAP.put(4, "IV");
        TREE_MAP.put(1, "I");
    }

    public static int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = HASH_MAP.get(s.charAt(i));

            if (i < s.length() - 1 && current < HASH_MAP.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }

    public static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int key = TREE_MAP.floorKey(num);
            sb.append(TREE_MAP.get(key));
            num -= key;
        }

        return sb.toString();
    }

    static void main() {
        System.out.println(romanToInt("LVIII"));   // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994

        System.out.println(intToRoman(58));     // LVIII
        System.out.println(intToRoman(1994));   // MCMXCIV
    }
}
