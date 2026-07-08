package com.myproject.introduction;

import java.util.Scanner;
import java.util.UUID;

public class Student {
    static Scanner sc = new Scanner(System.in);

    UUID sid;
    String fullName;
    byte age;
    String address;
    String city;
    String email;
    long phone;
    int[] marks = new int[5];


    static void main() {
        Student student = new Student();

        Student st = student.getStudent(student);
        System.out.println("-----Student Details-----");
        System.out.println("Student ID : " + st.sid);
        System.out.println("Student fullName : " + st.fullName);
        System.out.println("Student age : " + st.age);
        System.out.println("Student address : " + st.address);
        System.out.println("Student city : " + st.city);
        System.out.println("Student email : " + st.email);
        System.out.println("Student phone : " + st.phone);

        student.studentResultAnalyzer(student.marks);

    }

    Student getStudent(Student student) {
        student.sid = UUID.randomUUID();

        System.out.print("Enter student name: ");
        student.fullName = sc.nextLine();

        System.out.print("Enter student age: ");
        student.age = sc.nextByte();

        sc.nextLine(); // consume new line
        System.out.print("Enter student address: ");
        student.address = sc.nextLine();

        System.out.print("Enter student city: ");
        student.city = sc.nextLine();

        System.out.print("Enter student email: ");
        student.email = sc.next();

        System.out.print("Enter student phone: ");
        student.phone = sc.nextLong();

        System.out.println("Enter marks of 5 subjects: ");
        for (int i = 0; i < marks.length; i++) {
            marks[i] = sc.nextInt();
        }

        System.out.println("Sub 1 marks: " + student.marks[0]);
        System.out.println("Sub 2 marks: " + student.marks[1]);
        System.out.println("Sub 3 marks: " + student.marks[2]);
        System.out.println("Sub 4 marks: " + student.marks[3]);
        System.out.println("Sub 5 marks: " + student.marks[4]);

        return student;
    }

    void studentResultAnalyzer(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }

        System.out.println("The sum of the marks is " + sum);
        double p = calcPercentage(sum);

        System.out.println("Percent of marks is " + p + "%");
        double avg = calcAverage(sum);

        System.out.println("The average marks is " + avg);
    }

    double calcPercentage(int sum) {
        return (double) (sum) / (marks.length);
    }

    double calcAverage(int sum) {
        return (double) sum / marks.length;
    }
}
