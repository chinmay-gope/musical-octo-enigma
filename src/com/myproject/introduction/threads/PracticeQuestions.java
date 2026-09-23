package com.myproject.introduction.threads;

// Q) Print 1 to 30 in order. Odd & Even should be printed in two diff threads.
public class PracticeQuestions {
    static void main() {
        PracticeQuestions pq = new PracticeQuestions();

        try {
            pq.printOddEven();
        } catch (InterruptedException e) {
            System.out.println("Interrupted main : " + e.getMessage());
        }
    }

    void printOddEven() throws InterruptedException {
        Thread odd = new Thread(() -> {
            for (int i = 1; i <= 29; i = i + 2) {
                System.out.println(i + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(300); // This sleep should be greater than the sleep given between odd-even.start()
                } catch (InterruptedException e) {
                    System.out.println("Interrupted : " + e.getMessage());
                }
            }
        });
        Thread even = new Thread(() -> {
            for (int i = 2; i <= 30; i = i + 2) {
                System.out.println(i + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(300); // This sleep should be greater than the sleep given between odd-even.start()
                } catch (InterruptedException e) {
                    System.out.println("Interrupted : " + e.getMessage());
                }
            }
        });

        odd.start();
        Thread.sleep(200);
        even.start();
    }
}
