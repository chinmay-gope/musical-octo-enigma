package com.myproject.introduction;

import java.util.Scanner;

public class WhyThisPhysics {

    double calculateSpeed(double distance, double time) {
        return time > 0 ? distance / time : 0.0;
    }

    double calculateDistance(double speed, double time) {
        return speed * time;
    }

    double calculateForce(double mass, double acceleration) {
        return mass * acceleration;
    }

    double calculateMomentum(double mass, double velocity) {
        return mass * velocity;
    }

    double calculateKineticEnergy(double mass, double velocity) {
        return 0.5 * mass * velocity * velocity;
    }

    double calculatePotentialEnergy(double mass, double height, double gravity) {
        return mass * gravity * height;
    }

    double calculateWork(double force, double distance) {
        return force * distance;
    }

    double calculatePower(double work, double time) {
        return time > 0 ? work / time : 0.0;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        WhyThisPhysics physics = new WhyThisPhysics();

        // Speed
        System.out.print("Enter distance (m): ");
        double distance = sc.nextDouble();
        System.out.print("Enter time (s): ");
        double time = sc.nextDouble();
        System.out.println("Speed: " + physics.calculateSpeed(distance, time) + " m/s");

        // Distance
        System.out.print("\nEnter speed (m/s): ");
        double speed = sc.nextDouble();
        System.out.print("Enter time (s): ");
        double t2 = sc.nextDouble();
        System.out.println("Distance: " + physics.calculateDistance(speed, t2) + " m");

        // Force
        System.out.print("\nEnter mass (kg): ");
        double mass = sc.nextDouble();
        System.out.print("Enter acceleration (m/s^2): ");
        double acc = sc.nextDouble();
        System.out.println("Force: " + physics.calculateForce(mass, acc) + " N");

        // Momentum
        System.out.print("\nEnter velocity (m/s): ");
        double vel = sc.nextDouble();
        System.out.println("Momentum: " + physics.calculateMomentum(mass, vel) + " kg·m/s");

        // Kinetic Energy
        System.out.println("Kinetic Energy: " + physics.calculateKineticEnergy(mass, vel) + " J");

        // Potential Energy
        System.out.print("\nEnter height (m): ");
        double height = sc.nextDouble();
        System.out.print("Enter gravity (m/s^2): ");
        double g = sc.nextDouble();
        System.out.println("Potential Energy: " + physics.calculatePotentialEnergy(mass, height, g) + " J");

        // Work
        System.out.print("\nEnter force (N): ");
        double force = sc.nextDouble();
        System.out.print("Enter distance (m): ");
        double d2 = sc.nextDouble();
        System.out.println("Work: " + physics.calculateWork(force, d2) + " J");

        // Power
        System.out.print("\nEnter work (J): ");
        double work = sc.nextDouble();
        System.out.print("Enter time (s): ");
        double t3 = sc.nextDouble();
        System.out.println("Power: " + physics.calculatePower(work, t3) + " W");
    }
}
