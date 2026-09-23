package com.myproject.introduction.threads;

public class TaskService2 {
    static void main() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println("Executing task1 " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted " + e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Executing task2 " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted " + e.getMessage());
            }
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Executing task3 " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted " + e.getMessage());
            }
        });

        t1.start();
        t2.start();
        t3.start();

        // main thread should tail till t1, t2, t3 are completed
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Main thread executed");
    }
}
