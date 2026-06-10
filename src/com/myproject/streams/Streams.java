package com.myproject.streams;

import java.util.Arrays;
import java.util.List;

public class Streams {
    static void main() {
        List<Integer> integerList = Arrays.asList(3, 5, 2, 7, 8, 20, 5, 7);

        List<String> fruits = Arrays.asList("apple", "orange", "banana", "kiwi");
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

        List<String> list = fruits.stream().map(String::toUpperCase).toList();

        //  numbers.stream().map(Integer::valueOf).forEach(System.out::print);
        System.out.println(numbers.stream().map(Integer::valueOf).reduce(0, Integer::sum));

        numbers.stream().map(Integer::valueOf).filter(n -> n % 2 == 0).forEach(System.out::println);

        List<Integer> integers = integerList.stream()
                .distinct()
                .filter(n -> n % 2 != 0)
                .filter(n -> n > 3)
                .toList();

        System.out.println(list);
        System.out.println(integers);
    }
}
