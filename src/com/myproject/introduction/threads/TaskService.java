package com.myproject.introduction.threads;

public class TaskService {
    static void main() {
       /* Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());
        Thread t3 = new Thread(new Task3());

        t1.start();
        t2.start();
        t3.start();*/

        // Using Lambda expressions
        Thread t1 = new Thread(() ->
                System.out.println("Executing task1 " + Thread.currentThread().getName())
        );
        Thread t2 = new Thread(() ->
                System.out.println("Executing task2 " + Thread.currentThread().getName())
        );
        Thread t3 = new Thread(() ->
                System.out.println("Executing task3 " + Thread.currentThread().getName())
        );

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main thread executed");
    }
}
