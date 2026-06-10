package com.myproject.introduction;

public class Introduction {
    static void main() throws ClassNotFoundException {
        System.out.println("Hello World");

        Class.forName("java.lang.System");
        Class.forName("java.lang.String");
        Class.forName("java.math.BigInteger");
        Class.forName("com.myproject.introduction.Movie");

        String s = "HelloWorld";

        System.out.println(s.charAt(0));
        System.out.println(s.substring(5));
        System.out.println(s.subSequence(0, 5));

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Main method ended!");
    }
}
