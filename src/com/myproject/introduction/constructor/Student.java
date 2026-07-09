package com.myproject.introduction.constructor;

public class Student {
    int sid, sage;
    String sName;

    Student() {

    }

    Student(int id, String name, int age) {
        System.out.println("Parameterized constructor");
        this.sid = id;
        this.sName = name;
        this.sage = age;
    }

    static void main() {
        Student s1 = new Student(); //Default constructor
//        s1.display();

        Student s2 = new Student(101, "Tony", 23);
        s2.display();
    }

    void display() {
        System.out.println(sid);
        System.out.println(sName);
        System.out.println(sage);
    }
}
