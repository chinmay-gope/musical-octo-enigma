package com.myproject.introduction.constructor;

class Mammal {
    Mammal() {
        System.out.println("Mammal constructor");
    }

    Mammal(int age) {
        System.out.println("Mammal constructor with age " + age);
    }
}

class Animal extends Mammal {
    Animal() {
        super(10);
        System.out.println("Animal constructor");
    }

    Animal(int age) {
        super(age);
        System.out.println("Animal constructor with age " + age);
    }
}

public class Dog extends Animal {
    Dog(int age) {
        super(age);
    }

    Dog() {
        this(30);
        System.out.println("Dog constructor");
    }

    static void main() {
        Dog d = new Dog();
        Animal a = new Animal();
        Mammal m = new Mammal(22);
    }

}
