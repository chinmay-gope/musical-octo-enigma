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

    static void main() {
        Student student = new Student();
        int[] marks = new int[5];
        marks[0] = 100;
        marks[1] = 99;
        marks[2] = 97;
        marks[3] = 96;
        marks[4] = 98;

        IO.println(student.rollNo);
        IO.println(student.name);
        IO.println(student.age);
        IO.println(student.gender);
        IO.println(student.section);
        IO.println(Arrays.toString(marks));
        IO.println(student.percentage + " %");
        IO.println(student.passedStatus);
    }
}
