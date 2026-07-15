package com.myproject.introduction.constructor;

import java.util.Objects;

public class Employee {
    Employee() {
        System.out.println("Employee constructor");
    }

    int id;
    int age;
    String name;

    Employee(int id, int age, String name) {
        System.out.println("Employee Parameterized constructor");
        Employee e = new Employee();

        System.out.println("Employee HashCode " + e.hashCode());

        e.id = id;
        e.age = age;
        e.name = name;
//        this.id = id;
//        this.age = age;
//        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Employee other)) return false;

        return id == other.id &&
                age == other.age &&
                Objects.equals(name, other.name);
    }

    static void main() {
        System.out.println("main method started");
        Employee e1 = new Employee(11, 23, "Tony");
        System.out.println("Main Method e1 " + e1.hashCode());

        Employee e2 = new Employee(11, 23, "Tony");
        System.out.println("Main Method e2 " + e2.hashCode());

        System.out.println(e1.id);
        System.out.println(e1.name);
        System.out.println(e1.age);
        System.out.println("_____________________");
        System.out.println(e2.id);
        System.out.println(e2.name);
        System.out.println(e2.age);

        System.out.println(e1.equals(e2));
        System.out.println(e1 == e2);
        System.out.println("main method ended");
    }
}
