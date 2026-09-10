package com.myproject.introduction.abstraction.impl;

import com.myproject.introduction.abstraction.Vehicle;

public class Bike implements Vehicle {
    static void main() {
        Vehicle bike = new Bike();
        bike.start();
        bike.stop();
    }

    @Override
    public void start() {
        System.out.println("Bike is starting...");
        System.out.println("🚴‍♂️💨");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping...");
    }
}
