package com.myproject.introduction;

import java.util.Scanner;

public class MyString {
    static Scanner sc = new Scanner(System.in);

    static void main() {
        MyString obj = new MyString();
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine().trim();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine().trim();

        System.out.println("Full Name: " + obj.getFullName(firstName, lastName));
        System.out.println("Initials: " + obj.getInitials(firstName, lastName));

        System.out.print("Enter any text: ");
        String text = sc.nextLine();

        System.out.println("Reversed: " + obj.reverse(text));
        System.out.println("Uppercase: " + obj.toUpper(text));
        System.out.println("Lowercase: " + obj.toLower(text));
        System.out.println("Repeated (3): " + obj.repeatText(text, 3));
        System.out.println("Repeated (5): " + obj.repeatText(text, 5));
        System.out.println("Without spaces: " + obj.removeSpaces(text));
        System.out.println("Character count: " + obj.countCharacters(text));
        System.out.println("First character: " + obj.firstCharacter(text));
        System.out.println("Last character: " + obj.lastCharacter(text));
    }

    String getFullName(String first, String last) {
        return first + " " + last;
    }


    String getInitials(String first, String last) {
        return "Initial : " + first.charAt(0) + last.charAt(0);
    }

    String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    String toUpper(String text) {
        return text.toUpperCase();
    }

    String toLower(String text) {
        return text.toLowerCase();
    }

    String repeatText(String text, int times) {
        return text.repeat(times);
    }

    String removeSpaces(String text) {
        return text.replace(" ", "");
    }

    int countCharacters(String text) {
        return text.length();
    }

    char firstCharacter(String text) {
        return text.charAt(0);
    }

    char lastCharacter(String text) {
        return text.charAt(text.length() - 1);
    }
}
