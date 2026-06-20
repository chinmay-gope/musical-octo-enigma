package com.myproject.data_structures.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitManipulation {

    void digitManipulation(int n) {
        Map<String, Object> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int sum = 0, count = 0, reverse = 0;

        while (n != 0) {
            int digit = n % 10;

            count++;
            sum += digit;
            reverse = reverse * 10 + digit;
            list.add(digit);

            map.put("Reverse", reverse);
            map.put("Digits", list);
            map.put("Count", count);
            map.put("Sum", sum);

            n = n / 10;
        }
        IO.println(map);
    }

    void main() {
        int N = 3568;
        digitManipulation(N);
        IO.println((int) Math.log10(N) + 1); //count shortcut
    }
}
