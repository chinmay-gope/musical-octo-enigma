package com.myproject.introduction.accessmodfr;

public class Customer {
    private String name;
    private String phoneNumber;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.trim().isEmpty() || !name.isBlank()) {
            this.name = name;
        }

        System.err.println("Name cannot be empty");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10) {
            System.err.println("Invalid Phone Number");
            return;
        }
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email.contains("@")) {
            this.email = email;
        } else {
            System.err.println("Invalid Email, Please enter a valid email.");
        }
    }
}
