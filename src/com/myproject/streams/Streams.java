package com.myproject.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    List<String> fruits = Arrays.asList("apple", "mango", "orange", "banana");

    Stream<String> s = fruits.stream();

}
