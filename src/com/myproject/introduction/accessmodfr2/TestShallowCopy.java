package com.myproject.introduction.accessmodfr2;

class Student implements Cloneable {
    int id;
    String name;
    ShallowAddress address;

    public Student(int id, String name, ShallowAddress address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void display() {
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("ShallowAddress : " + address.city);
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}

class ShallowAddress {
    String city;

    ShallowAddress(String city) {
        this.city = city;
    }
}

public class TestShallowCopy {

    static void main() throws CloneNotSupportedException {

        ShallowAddress address = new ShallowAddress("Uppal");

        Student s1 = new Student(6, "John Doe", address);

        // Clone s1
        Student s2 = s1.clone();

        System.out.println("Before changing s2:");
        s1.display();
        s2.display();

        // Change the nested object through s2
        s2.id = 7;
        s2.name = "Jane";
        s2.address.city = "New York";

        System.out.println("\nAfter changing s2.address.city:");
        s1.display();
        s2.display();

        System.out.println("\nSame Student object? " + (s1 == s2));
        System.out.println("Same ShallowAddress object? " + (s1.address == s2.address));
    }
}
