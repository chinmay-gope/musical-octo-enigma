package com.myproject.introduction.threads;

public class Task1 implements Runnable {
    public void print() {
        System.out.println("Task1 " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        print();
    }
}
