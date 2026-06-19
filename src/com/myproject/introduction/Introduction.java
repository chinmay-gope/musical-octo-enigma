package com.myproject.introduction;

import java.util.ArrayList;

public class Introduction {
    static void main() {
        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        for (String s : list) {
            if (s.equals("B")) {
                list.remove(s);
            }
        }

        System.out.println(list);
    }
}
