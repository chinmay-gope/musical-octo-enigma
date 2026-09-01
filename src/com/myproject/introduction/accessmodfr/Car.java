package com.myproject.introduction.accessmodfr;

class Vehicle {
    Vehicle() {
        System.out.println("Vehicle Constructor called");
    }

    void start() {
        System.out.println("Vehicle is starting ...");
    }
}


public class Car extends Vehicle {

    static void main() {

        Car car = new Car();

        car.start();
        car.drive();

    }

    void drive() {
        System.out.println("Car is starting ...");
        System.out.println("vroom vroom !!");
    }
}
