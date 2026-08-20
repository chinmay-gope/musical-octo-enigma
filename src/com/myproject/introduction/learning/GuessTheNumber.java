package com.myproject.introduction.learning;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    static void main() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int bound = 50;
        int target = random.nextInt(bound);
        int chances = 3;

        System.out.println("target = " + target);
        System.out.println("Guess a number between 0 and " + bound + ":");

        while (chances > 0) {
            int guess = sc.nextInt();

            if (guess == target) {
                System.out.println("Correct! You won!");
                return;
            } else if (guess < target) {
                System.out.println("Guess higher...");
            } else {
                System.out.println("Guess lower...");
            }

            chances--;
        }

        System.out.println("You can leave for the day! The number was " + target);
        sc.close();
    }
}
