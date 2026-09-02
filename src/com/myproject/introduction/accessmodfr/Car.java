package com.myproject.introduction.accessmodfr;

class Vehicle {
    Vehicle() {
        System.out.println("Vehicle Constructor called");
    }

    void start() {
        System.out.println("Parent Vehicle is starting ...");
    }
}

public class Car extends Vehicle {

    static void main() {

        Car car = new Car();
        Vehicle vehicle = new Vehicle();
        Vehicle vehicle2 = new Car(); // Abstraction
//        Car vehicle3 = (Car) new Vehicle(); // ClassCastException

        System.out.println("---------------");
        vehicle.start(); // parent meth() only;
        System.out.println("---------------");
        vehicle2.start(); // references parent meth() but executes child meth() (Dynamic Method Dispatch);

        System.out.println("---------------");
        car.start();
        car.drive();
    }

    void drive() {
        System.out.println("vroom vroom 🚴‍♂️💨!!");
    }

    @Override
    void start() {
        super.start();
        System.out.println("Car is starting ...");
    }
}
