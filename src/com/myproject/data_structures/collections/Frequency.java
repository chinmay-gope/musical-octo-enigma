package com.myproject.data_structures.collections;

import java.util.*;

public class Frequency {
    static void main() {
        int[] nums = {10, 2, 3, 3, 2, 2, 3, 10};

        String[] words = {"cat", "ten", "tak", "cat", "net", "tac", "kat", "tic", "pen", "ten", "nep"};

        countFrequency(nums);

        System.out.println("checkAnagram(\"cat\", \"tac\") = " + checkAnagram("cat", "act"));

        List<List<String>> anagrams = groupAnagrams(words);
        System.out.println("anagramsList = " + anagrams);

        maxFrequency("banana");
    }

    public static void countFrequency(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);

            else {
                map.put(num, map.get(num) + 1);
            }
        }

        System.out.println(map);
    }

    public static void maxFrequency(String word) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char maxChar = '\0';
        int maxFreq = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        System.out.println("Frequency Map: " + map);
        System.out.println("Max Frequency Character: " + maxChar);
        System.out.println("Frequency: " + maxFreq);
    }

    public static boolean checkAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) return false;

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }


    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            map.computeIfAbsent(key, _ -> new ArrayList<>()).add(word);
        }


        return new ArrayList<>(map.values());
    }
}
