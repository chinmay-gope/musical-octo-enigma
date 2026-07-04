package com.myproject.introduction;

public class TestDemo {
    static void main() {

        int x = 10;
        System.out.println("Value of x : " + (x = x++));

        System.out.println("Boolean.parseBoolean : " + Boolean.parseBoolean("TRUE"));

        int i = 100;
        long l = 100L;
        System.out.println("100 == 100L : " + (l == i));

        Integer i1 = 100;
        Integer i2 = new Integer(100);
        System.out.println("100 = new Integer(100) : " + (i1 == i2));

        Integer i3 = 100;
        Long i4 = new Long(100L);
        long i5 = 100L;

        System.out.println("i3.equals(i4) : " + i3.equals(i4));
        System.out.println("i3.equals(i5) : " + i3.equals(i5));
    }
}
