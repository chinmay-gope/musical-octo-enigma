package com.myproject.introduction.learning;

import java.util.Scanner;

public class Lab4 {
    int m1, m2, m3, m4, m5;
    int s1, s2, s3;

    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks of 5 subjects: ");
        m1 = sc.nextInt();
        m2 = sc.nextInt();
        m3 = sc.nextInt();
        m4 = sc.nextInt();
        m5 = sc.nextInt();

        float percentage = calcPercentage();
        char grade = calcGrade();

        System.out.println("The percentage is " + percentage);
        System.out.println("Grade = " + grade);

        System.out.println("Enter sides of Triangle: ");
        s1 = sc.nextInt();
        s2 = sc.nextInt();
        s3 = sc.nextInt();
        isValidTriangle();
    }

    private char calcGrade() {
        float percent = calcPercentage();

//        if (percent >= 90) {
//            return 'A';
//        } else if (percent >= 75) {
//            return 'B';
//        } else if (percent >= 60) {
//            return 'C';
//        } else if (percent >= 50) {
//            return 'D';
//        }
//        return 'F';

        return percent >= 90 ? 'A' : percent >= 75 ? 'B' : percent >= 60 ? 'C' : percent >= 50 ? 'D' : 'F';
    }

    private float calcPercentage() {
        int sum = m1 + m2 + m3 + m4 + m5;
        return (float) sum / 5;
    }

    void isValidTriangle() {

        if (s1 + s2 > s3 && s2 + s3 > s1 && s1 + s3 > s2) {
            System.out.printf("Triangle is valid for sides  %d %d %d \n", s1, s2, s3);
        } else {
            System.out.printf("Triangle is in-valid for sides  %d %d %d \n", s1, s2, s3);
        }
    }

}
