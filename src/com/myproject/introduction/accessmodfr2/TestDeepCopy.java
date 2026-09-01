package com.myproject.introduction.accessmodfr2;

class DeepStudent implements Cloneable {
    int id;
    String name;
    DeepAddress address;

    public DeepStudent(DeepStudent student) throws CloneNotSupportedException {
        this.id = student.id;
        this.name = student.name;
        this.address = new DeepAddress(student.address.city);
//        this.address = (DeepAddress) student.address.clone(); // using .clone()

//        DeepAddress address = new DeepAddress(student.address.city);
//        this.address = address;
    }

    public DeepStudent(int id, String name, DeepAddress address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void display() {
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("DeepAddress : " + address.city);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class DeepAddress implements Cloneable {
    String city;

    DeepAddress(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestDeepCopy {
    static void main() throws CloneNotSupportedException {
        DeepAddress address = new DeepAddress("Uppal");

        DeepStudent s1 = new DeepStudent(6, "John Doe", address);

        // Clone s1
        DeepStudent s2 = new DeepStudent(s1);

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
        System.out.println("Same DeepAddress object? " + (s1.address == s2.address));
    }
}
