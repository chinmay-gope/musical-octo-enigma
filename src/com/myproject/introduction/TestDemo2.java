package com.myproject.introduction;

public class TestDemo2 {
    static void main() {
        String str1 = "Hello";
        StringBuffer str2 = new StringBuffer("Hello");

        str1.concat(" World");
        str2.append(" World");
        String str3 = str1.concat(" World");

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        String s1 = String.valueOf("".length());
        s1 = s1.concat("");
        System.out.println(s1.length());
    }
}
