package com.myproject.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Streams2 {

    List<String> names = new ArrayList<>(Arrays.asList("John", "Jane", "Jack", "Jill", "Miles", "Gwen"));

    void main() {
        stream1();
        stream2();
        stream3();
        stream4();
        stream5();
        stream6();
    }

    void stream1() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> collected = list.stream().filter(elem -> {
            System.out.println("Filtering element " + elem);
            return elem % 2 == 1;

        }).map(elem -> {
            System.out.println("Mapping element " + elem);
            return elem * 2;
        }).toList();

        System.out.println("Collected elements: " + collected);
    }

    void stream2() {
        Optional<String> first = names.stream().filter(name -> name.startsWith("J")).findFirst();
//              .findAny(); // mostly used in parallel processing

        System.out.println("Streams2.stream2 : " + first.get());
    }

    void stream3() {
        boolean value = names.stream().anyMatch(name -> name.startsWith("J"));
        System.out.println("Streams2.stream3 : " + value);
    }

    void stream4() {
        boolean value = names.stream().allMatch(name -> name.length() >= 4);
        System.out.println("Streams2.stream4 : " + value);
    }

    void stream5() {
        boolean value = names.stream().noneMatch(name -> name.startsWith("Pe"));
        System.out.println("Streams2.stream5 : " + value);
    }

    void stream6() {

        List<Integer> list = new ArrayList<>(Arrays.asList(3, 2, 2, -1, 54, 20));

        list.stream().sorted().forEach(num -> System.out.print(num + ", "));

        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println("Streams2.stream6.sum : " + sum);
    }
}
