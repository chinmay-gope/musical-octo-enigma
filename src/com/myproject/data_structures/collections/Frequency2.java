package com.myproject.data_structures.collections;

import java.util.*;

public class Frequency2 {
    static void main() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        topK(nums, 2);
    }


    public static void topK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

//        Comparator.comparingInt(map::get)  same as (a, b) -> map.get(a) - map.get(b)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get)); // Create min-heap

//      Keep only topK freq elements
        for (int num : map.keySet()) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }


        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        System.out.println("result = " + result);
    }
}
