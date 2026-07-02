package com.myproject.introduction;

import java.util.Arrays;

public class Student {
    byte age = 22;
    int rollNo = 6606;
    String name = "v1spr";
    char gender = 'M';
    char section = 'A';
    //    int[] marks = {10, 20, 30, 40, 50};
    float percentage = 75.12F;
    boolean passedStatus = true;

    void main() {
        Student student = new Student();
        int[] marks = new int[5];
        marks[0] = 100;
        marks[1] = 99;
        marks[2] = 97;
        marks[3] = 96;
        marks[4] = 98;

        String n1 = "100";
        String n2 = "99.99";
        String n3 = "true";
        char n4 = 'A';

        int num1 = Integer.parseInt(n1);
        double num2 = Double.parseDouble(n2);
        boolean num3 = Boolean.parseBoolean(n3);
        String num4 = Character.toString(n4);

        IO.println(num1 + " " + num2 + " " + num3 + " " + num4);

        IO.println(rollNo);
        IO.println(name);
        IO.println(age);
        IO.println(gender);
        IO.println(section);
        IO.println(Arrays.toString(marks));
        IO.println(percentage + " %");
        IO.println(passedStatus);
    }
}
