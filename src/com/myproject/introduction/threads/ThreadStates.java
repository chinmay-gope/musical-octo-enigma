package com.myproject.introduction.threads;

public class ThreadStates {

    static void main() throws InterruptedException {
        ThreadStates states = new ThreadStates();

//        states.newProof();
//        states.runnableProof();
//        states.timedWaitingProof();
//        states.blockedProof();
//        states.indefiniteWaitProof();
//        states.terminatedProof();
    }

    void newProof() {
        Thread t1 = new Thread(() -> System.out.println("Task in NEW state"));
        System.out.println("State before start: " + t1.getState()); // NEW
        t1.start();
    }

    void runnableProof() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                // busy loop
            }
        });
        t1.start();
        Thread.sleep(100); // let t1 run
        System.out.println("Runnable thread state: " + t1.getState()); // RUNNABLE

        t1.interrupt();
        t1.join(); // wait for it to actually finish
    }

    void timedWaitingProof() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000); // puts thread into TIMED_WAITING
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        t1.start();
        Thread.sleep(100); // give time to enter sleep
        System.out.println("Timed waiting thread state: " + t1.getState()); // TIMED_WAITING
    }

    void blockedProof() throws InterruptedException {
        final Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000); // holds lock
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 acquired lock");
            }
        });

        t1.start();
        Thread.sleep(100); // ensure t1 holds lock
        t2.start();
        Thread.sleep(100); // give t2 chance to block
        System.out.println("Blocked thread state: " + t2.getState()); // BLOCKED

    }

    void terminatedProof() throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("Thread finishing..."));
        t1.start();
        t1.join(); // wait until finished
        System.out.println("Terminated thread state: " + t1.getState()); // TERMINATED
    }

    void indefiniteWaitProof() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            // Code logic that takes up a lot of time
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        System.out.println("Thread is about to wait.");
        t1.join();
        System.out.println("thread completed.");
    }
}
