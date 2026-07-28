package com.myproject.introduction.constructor;

public class Lab3 {

    int seconds = 3610;

    void main() {
        calcHours(seconds);
        calcMinutes(seconds);
    }


    void calcHours(int seconds) {
        int hours = seconds / 3600;
        System.out.println(hours + " Hours");
    }

    void calcMinutes(int seconds) {
        int minutes = seconds / 60;
        System.out.println(minutes + " Minutes");
    }
}
