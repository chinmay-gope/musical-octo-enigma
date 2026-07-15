package com.myproject.introduction.constructor;

import java.util.UUID;

public class College {
    String name, city;
    int numOfStudents;

    String ID;

    College() {
        System.out.println("Instantiating College object");
        this.ID = UUID.randomUUID().toString();
    }

    College(String name) {
        this(name, "Unknown");
    }

    College(String name, String city) {
        this(name, city, 0);
    }

    College(String name, String city, int numOfStudents) {
        this.name = name;
        this.city = city;
        this.numOfStudents = numOfStudents;
        this.ID = UUID.randomUUID().toString();
    }

    void show() {
        System.out.println("Student ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of students: " + numOfStudents);
        System.out.println("_______________________________");
    }

    static void main() {
        College c1 = new College("CBIT");
        c1.show();

        College c2 = new College("ATRI", "KPHB");
        c2.show();

        College c3 = new College("Apna College", "Mumbai", 30_000);
        c3.show();

        College c4 = new College();
        c4.show();
    }
}
