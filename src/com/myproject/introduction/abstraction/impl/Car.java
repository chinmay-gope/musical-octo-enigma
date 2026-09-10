package com.myproject.introduction.abstraction.impl;

import com.myproject.introduction.abstraction.Vehicle;

public class Car implements Vehicle {
    static void main() {
        Vehicle car = new Car();
        car.start();
        car.stop();
    }

    @Override
    public void start() {
        System.out.println("Car starting...");
        System.out.println("🚗💨");
    }

    @Override
    public void stop() {
        System.out.println("Car stoping...");
    }
}
